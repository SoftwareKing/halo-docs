package io.httpdoc.core.annotation;

import java.lang.annotation.*;

/**
 * 翻译时忽略
 *
 * @author
 * @date 2018-06-29 15:05
 **/
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Ignore {
}
