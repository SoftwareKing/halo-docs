package io.detector;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类路径资源
 *
 * @author Payne 646742615@qq.com
 * 2018/11/27 10:52
 */
public abstract class ClasspathResource implements Resource {
    protected final ClassLoader classLoader;
    private final Object lock = new Object();
    protected InputStream inputStream;

    protected ClasspathResource(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public InputStream getInputStream() throws IOException {
        if (inputStream != null) {
            return inputStream;
        }
        synchronized (lock) {
            if (inputStream != null) {
                return inputStream;
            }
            inputStream = newInputStream();
        }
        return inputStream;
    }

    public InputStream newInputStream() throws IOException {
        return getUrl().openStream();
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public boolean isClass() {
        return getUrl().getFile().endsWith(".class");
    }

    public Class<?> toClass() {
        String className = getName();
        if (className.startsWith("/")) {
            className = className.substring("/".length());
        }
        if (className.endsWith(".class")) {
            className = className.substring(0, className.length() - ".class".length());
        }
        if (className.contains("/")) {
            className = className.replace('/', '.');
        }
        try {
            return classLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * just close the input stream opened by method {@link JarResource#getInputStream()}
     */
    public void close() throws IOException {
        if (inputStream != null) {
            inputStream.close();
        }
    }
}
