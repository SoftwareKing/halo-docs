package org.xujin.docs.web;

import org.xujin.doc.core.Config;
import org.xujin.doc.core.Lifecycle;
import org.xujin.doc.core.exception.HttpdocRuntimeException;
import org.xujin.doc.core.kit.LoadKit;
import org.xujin.doc.core.serialization.Serializer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

/**
 * 智能序列化器
 * @author xujin
 **/
public class HttpdocSuffixSerializer implements Serializer, Lifecycle {
    private final Map<String, Serializer> map = LoadKit.load(this.getClass().getClassLoader(), Serializer.class);

    private Serializer get() {
        HttpServletRequest request = HttpdocThreadLocal.getRequest();
        String uri = request.getRequestURI();
        int index = uri.lastIndexOf(".");
        if (index < 0) return map.values().iterator().next();
        String suffix = uri.substring(index + 1);
        Serializer serializer = map.get(suffix);
        if (serializer == null) throw new HttpdocRuntimeException("unknown serializer named " + suffix);
        return serializer;
    }

    @Override
    public String getName() {
        return get().getName();
    }

    @Override
    public String getType() {
        return get().getType();
    }

    @Override
    public void serialize(Map<String, Object> doc, OutputStream out) throws IOException {
        get().serialize(doc, out);
    }

    @Override
    public void serialize(Map<String, Object> doc, Writer writer) throws IOException {
        get().serialize(doc, writer);
    }

    @Override
    public void initial(Config config) throws Exception {
        for (Serializer serializer : map.values()) {
            if (serializer instanceof Lifecycle) {
                ((Lifecycle) serializer).initial(config);
            }
        }
    }

    @Override
    public void destroy() {
        for (Serializer serializer : map.values()) {
            if (serializer instanceof Lifecycle) {
                ((Lifecycle) serializer).destroy();
            }
        }
    }
}
