package org.xujin.doc.core.generation;

import org.xujin.doc.core.Schema;

/**
 * Schema生成上下文
 *
 * @author
 * @date 2018-07-10 10:45
 **/
public class SchemaGenerateContext extends GenerateContext {
    private final Schema schema;

    public SchemaGenerateContext(Generation generation, Schema schema) {
        super(generation);
        this.schema = schema;
    }

    public Schema getSchema() {
        return schema;
    }
}
