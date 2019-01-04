package io.detector;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * <p>
 * Description: Normal disk file as a resource
 * </p>
 *
 * <p>
 * Company: 广州市俏狐信息科技有限公司
 * </p>
 *
 * @author Payne 646742615@qq.com
 * @date 2016年1月16日 下午3:08:23
 * @since 1.0.0
 */
public class FileResource extends ClasspathResource implements Resource {
    private final String name;
    private final URL url;

    public FileResource(URL classpath, File file, ClassLoader classLoader) throws IOException {
        super(classLoader);
        try {
            this.name = classpath.toURI().relativize(file.toURI()).toString();
            this.url = new URL(classpath, name);
        } catch (URISyntaxException e) {
            throw new IOException(e);
        }
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
