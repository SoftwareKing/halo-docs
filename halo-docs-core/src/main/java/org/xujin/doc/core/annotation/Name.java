package org.xujin.doc.core.annotation;

import java.lang.annotation.*;

/**
 * 重定义翻译名称
 *
 * @author
 * @date 2018-06-29 15:03
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Name {

    String value();

}
