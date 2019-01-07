package org.xujin.halo.docs.starter;

import org.xujin.doc.core.conversion.Converter;
import org.xujin.doc.core.conversion.StandardConverter;
import org.xujin.doc.core.interpretation.Interpreter;
import org.xujin.doc.core.interpretation.SourceInterpreter;
import org.xujin.doc.core.serialization.Serializer;
import org.xujin.doc.core.supplier.Supplier;
import org.xujin.doc.core.supplier.SystemSupplier;
import org.xujin.doc.core.translation.Translator;
import org.xujin.docs.jackson.serialization.JsonSerializer;
import org.xujin.docs.web.HttpdocConversionProvider;
import org.xujin.docs.web.DocFilter;
import org.xujin.docs.web.HttpdocMergedTranslator;
import org.xujin.docs.web.conversion.ConversionProvider;
import org.springframework.context.annotation.Import;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.lang.annotation.*;

/**
 * HttpDoc 框架与 Spring Boot 集成注解
 *
 * @author
 * @date 2018-08-08 9:45
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Import(HttpdocFilterRegistrar.class)
public @interface EnableDoc {

    /**
     * @return Java src packages to scan
     */
    String[] packages();

    /**
     * @return Filter name
     */
    String name() default "HaloDocs";

    /**
     * @return Filter bean name
     */
    String bean() default "HaloDocs";

    /**
     * @return Filter async supported
     */
    boolean asyncSupported() default true;

    /**
     * @return Filter dispatcher type supported, empty means all.
     */
    DispatcherType[] dispatcherTypes() default {DispatcherType.REQUEST};

    /**
     * @return Filter match after
     */
    boolean matchAfter() default false;

    /**
     * @return Filter enabled
     */
    boolean enabled() default true;

    /**
     * @return URL patterns
     */
    String[] value() default {"/docs","/docs.json"};

    /**
     * @return Filter Class
     */
    Class<? extends Filter> filter() default DocFilter.class;

    /**
     * @return Filter Order
     */
    int order() default Integer.MAX_VALUE;

    /**
     * @return Filter Init Parameters
     */
    Param[] params() default {};

    /**
     * @return Project Name
     */
    String httpdoc() default "";

    /**
     * @return Network Protocol
     */
    String protocol() default "";

    /**
     * @return Server Hostname
     */
    String hostname() default "";

    /**
     * @return Server Port
     */
    int port() default -1;

    /**
     * @return Server Context Path
     */
    String context() default "";

    /**
     * @return Server API Version
     */
    String version() default "";

    /**
     * @return Date Format
     */
    String dateFormat() default "yyyy-MM-dd HH:mm:ss";

    /**
     * @return Project Description
     */
    String description() default "";

    /**
     * @return Document charset
     */
    String charset() default "";

    /**
     * @return Document Content Type
     */
    String contentType() default "";

    /**
     * @return Document Translator
     */
    Class<? extends Translator> translator() default HttpdocMergedTranslator.class;

    /**
     * Java基本类型提供者
     * @return Document Supplier
     */
    Class<? extends Supplier> supplier() default SystemSupplier.class;

    /**
     * Java Doc源代码拦截器，获取Java Doc信息
     * @return Document Interpreter
     */
    Class<? extends Interpreter> interpreter() default SourceInterpreter.class;

    /**
     * 文档转换器
     * 所有Controller或者Rest Controller注解的来源
     * @return Document Converter
     */
    Class<? extends Converter> converter() default StandardConverter.class;

    /**
     * 文档序列化工具
     * @return Document Serializer
     */
    Class<? extends Serializer> serializer() default JsonSerializer.class;

    /**
     * 配置类转换器提供者
     * @return Document Conversion Provider
     */
    Class<? extends ConversionProvider> conversionProvider() default HttpdocConversionProvider.class;

}
