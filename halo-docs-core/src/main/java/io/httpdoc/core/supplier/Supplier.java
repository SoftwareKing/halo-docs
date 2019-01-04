package io.httpdoc.core.supplier;

import io.httpdoc.core.Schema;

import java.lang.reflect.Type;

/**
 * 基本资源模型提供者
 *
 * @author
 * @date 2018-04-16 13:42
 **/
public interface Supplier {

    boolean contains(Type type);

    Schema acquire(Type type);

    boolean contains(Schema schema);

    Type acquire(Schema schema);

}
