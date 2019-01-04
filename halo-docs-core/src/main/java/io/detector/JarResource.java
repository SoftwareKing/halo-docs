package io.detector;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.jar.JarEntry;

/**
 * <p>
 * Description: JAR Nested Resource
 * </p>
 *
 * <p>
 * Company: 广州市俏狐信息科技有限公司
 * </p>
 *
 * @author Payne 646742615@qq.com
 * @date 2016年1月16日 下午3:10:30
 * @since 1.0.0
 */
public class JarResource extends ClasspathResource implements Resource {
    private final String name;
    private final URL url;

    public JarResource(URL classpath, JarEntry jarEntry, ClassLoader classLoader) throws IOException {
        super(classLoader);
        this.name = jarEntry.getName();
        this.url = new URL(classpath, UriKit.encodePath(name, Charset.defaultCharset()));
    }

    public String getName() {
        return name;
    }

    public URL getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url.toString();
    }
}
