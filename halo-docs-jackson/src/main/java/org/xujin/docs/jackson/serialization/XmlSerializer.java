package org.xujin.docs.jackson.serialization;

import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.xujin.doc.core.serialization.Serializer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

/**
 * Xml文档序列化器
 *
 * @author
 * @date 2018-04-24 12:27
 **/
public class XmlSerializer implements Serializer {
    private final XmlMapper mapper;

    public XmlSerializer() {
        this(new XmlFactory());
    }

    public XmlSerializer(XmlFactory factory) {
        this(new XmlMapper(factory));
    }

    public XmlSerializer(XmlMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String getName() {
        return "xml";
    }

    @Override
    public String getType() {
        return "application/xml";
    }

    @Override
    public void serialize(Map<String, Object> doc, OutputStream out) throws IOException {
        mapper.writeValue(out, doc);
    }

    @Override
    public void serialize(Map<String, Object> doc, Writer writer) throws IOException {
        mapper.writeValue(writer, doc);
    }
}
