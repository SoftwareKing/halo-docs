package io.httpdoc.core.annotation;

import java.lang.annotation.*;

/**
 * 重定义翻译包名
 *
 * @author
 * @date 2018-06-29 15:05
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Package {

    String value();

}
