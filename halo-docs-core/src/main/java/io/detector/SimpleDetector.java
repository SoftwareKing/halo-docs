package io.detector;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * <p>
 * Description: default resource detector, supports recursive or not recursive detection for the given root directory
 * </p>
 * <p>
 * <p>
 * Company: 广州市俏狐信息科技有限公司
 * </p>
 *
 * @author Payne 646742615@qq.com
 * @date 2016年1月16日 下午12:17:41
 * @since 1.0.0
 */
public class SimpleDetector implements Detector {
    private final String directory;
    private final boolean recursive;
    private final boolean jarIncluded;
    private final ClassLoader classLoader;

    /**
     * construct default resource detector using the self class loader
     *
     * @param directory   the root directory for detect
     * @param recursive   give me a true to make the detection recursively or give me a false for detect the directory only
     * @param classLoader resource loader
     */
    private SimpleDetector(String directory, boolean recursive, boolean jarIncluded, ClassLoader classLoader) {
        super();
        this.directory = directory;
        this.recursive = recursive;
        this.jarIncluded = jarIncluded;
        this.classLoader = classLoader;
    }

    /**
     * make the filter array to be a collection and call {@link SimpleDetector#detect(Collection)} simply
     */
    public Collection<Resource> detect(Filter... filters) throws IOException {
        return detect(filters != null ? Arrays.asList(filters) : new ArrayList<Filter>());
    }

    /**
     * make the filter collection to be a resource filter chain and call
     * {@link SimpleDetector#detect(FilterChain)} simply
     */
    public Collection<Resource> detect(Collection<Filter> filters) throws IOException {
        return detect(new FilterChain(filters != null ? filters : new ArrayList<Filter>()));
    }

    /**
     * detect all resources under the given directory {@link SimpleDetector#directory} by using mode
     * {@linkplain SimpleDetector#recursive} the detection not only include the project resource but also the
     * jar file referenced by the project
     */
    public Collection<Resource> detect(FilterChain chain) throws IOException {
        Collection<Resource> resources = new ArrayList<Resource>();
        // normalize and make it supports java package name
        String folder = directory.replace('.', '/');
        while (folder.startsWith("/")) folder = folder.substring(1);
        while (folder.endsWith("/")) folder = folder.substring(0, folder.length() - 1);
        Enumeration<URL> enumeration = classLoader.getResources(folder);
        // loop
        while (enumeration != null && enumeration.hasMoreElements()) {
            URL url = enumeration.nextElement();
            String protocol = url.getProtocol();
            // disk file
            if ("file".equalsIgnoreCase(protocol)) {
                String path = UriKit.decode(url.getPath(), Charset.defaultCharset());
                String root = path.substring(0, path.lastIndexOf(folder));
                URL classpath = new URL(url, "file:" + UriKit.encodePath(root, Charset.defaultCharset()));
                File file = new File(path);
                resources.addAll(detect(classpath, file, chain));
            }
            // jar file
            else if ("jar".equalsIgnoreCase(protocol) && jarIncluded) {
                String path = UriKit.decode(url.getPath(), Charset.defaultCharset());
                String root = path.substring(0, path.lastIndexOf(folder));
                URL classpath = new URL(url, "jar:" + UriKit.encodePath(root, Charset.defaultCharset()));
                JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                JarFile jarFile = jarURLConnection.getJarFile();
                resources.addAll(detect(classpath, jarFile, chain));
            }
        }
        return resources;
    }

    /**
     * detect disk file
     *
     * @param file file or directory
     * @return all of accepted resources under this directory file, or this file resource if it is an accepted file
     * resource
     * @throws IOException when I/O error occur
     */
    private Collection<Resource> detect(URL classpath, File file, FilterChain chain) throws IOException {
        Collection<Resource> resources = new ArrayList<Resource>();
        // if it is a directory and detector supports recursively detection go on dig
        if (file.isDirectory() && recursive) {
            File[] children = file.listFiles();
            if (children == null || children.length == 0) {
                return resources;
            }
            for (File child : children) {
                resources.addAll(detect(classpath, child, chain));
            }
        }
        // if it is a file, determine it is accepted or not
        else if (file.isFile()) {
            Resource resource = new FileResource(classpath, file, classLoader);
            if (chain.reset().doNext(resource)) {
                resources.add(resource);
            }
        }
        return resources;
    }

    /**
     * detect jar file
     *
     * @param jarFile jar library
     * @param chain   filter chain
     * @return all of accepted jar entry resources in the specified jar library
     * @throws IOException when I/O error occur
     */
    private Collection<Resource> detect(URL classpath, JarFile jarFile, FilterChain chain) throws IOException {
        Collection<Resource> resources = new ArrayList<Resource>();
        String root = directory.replace('.', '/');
        root = root.startsWith("/") ? root : "/" + root;
        root = root.endsWith("/") ? root : root + "/";
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            // ignore directory in jar file
            if (jarEntry.isDirectory()) {
                continue;
            }
            // normalize
            String path = "/" + jarEntry.getName();
            if (recursive) {
                if (path.startsWith(root)) {
                    Resource resource = new JarResource(classpath, jarEntry, classLoader);
                    if (chain.reset().doNext(resource)) resources.add(resource);
                }
            } else {
                path = path.substring(0, path.lastIndexOf('/') + 1);
                if (path.equals(root)) {
                    Resource resource = new JarResource(classpath, jarEntry, classLoader);
                    if (chain.reset().doNext(resource)) resources.add(resource);
                }
            }
        }
        return resources;
    }

    /**
     * the root directory of detection
     *
     * @return root directory
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * recursive detection or not?
     *
     * @return true: recursively false: not recursively
     */
    public boolean isRecursive() {
        return recursive;
    }

    /**
     * detect jar library?
     *
     * @return true: include jar library false: not include
     */
    public boolean isJarIncluded() {
        return jarIncluded;
    }

    /**
     * resource loader
     *
     * @return resource loader
     */
    public ClassLoader getClassLoader() {
        return classLoader;
    }

    /**
     * <p>
     * Description: Default resource detector builder
     * </p>
     * <p>
     * <p>
     * Company: 广州市俏狐信息科技有限公司
     * </p>
     *
     * @author Payne 646742615@qq.com
     * @date 2016年1月18日 上午10:38:45
     * @since 1.0.0
     */
    public static class Builder {
        private String directory;
        private boolean recursive = true;
        private boolean jarIncluded = true;
        private ClassLoader classLoader = Builder.class.getClassLoader();

        /**
         * Directory must not null, so it becomes constructor argument. use {@link Builder#scan(String)} the instance a
         * {@link Builder}
         *
         * @param directory the directory to scanned
         */
        private Builder(String directory) {
            this.directory = directory;
        }

        /**
         * Specify where the detection start from
         *
         * @param directory the directory to scanned
         * @return new default resource detector builder
         * @throws IllegalArgumentException if the directory is a {@link null} value
         */
        public static Builder scan(String directory) {
            if (directory == null) {
                throw new IllegalArgumentException("directory to scanned can not be a null value");
            }
            return new Builder(directory);
        }

        /**
         * make the detection recursively
         *
         * @return the builder's self
         */
        public Builder recursively() {
            this.recursive = true;
            return this;
        }

        /**
         * make the detection not recursively
         *
         * @return the builder's self
         */
        public Builder unrecursive() {
            this.recursive = false;
            return this;
        }

        /**
         * make the detection include jar library
         *
         * @return the builder's self
         */
        public Builder includeJar() {
            this.jarIncluded = true;
            return this;
        }

        /**
         * make the detection exclude jar library
         *
         * @return the builder's self
         */
        public Builder excludeJar() {
            this.jarIncluded = false;
            return this;
        }

        /**
         * Specify a class loader to load the resource
         *
         * @param classLoader class loader, by defaults, it use self's class loader.
         * @return the builder's self
         * @throws IllegalArgumentException if the class loader is a {@link null} value
         */
        public Builder by(ClassLoader classLoader) {
            if (classLoader == null) {
                throw new IllegalArgumentException("class loader to use can not be a null value");
            }
            this.classLoader = classLoader;
            return this;
        }

        /**
         * Build a new default resource detector
         *
         * @return new default resource detector
         */
        public SimpleDetector build() {
            return new SimpleDetector(directory, recursive, jarIncluded, classLoader);
        }
    }

}
