package org.xujin.doc.core.annotation;

import java.lang.annotation.*;

/**
 * 别名, 为了适配不同语言之间有些关键字不同的问题, 通过别名和JSON KEY转换
 *
 * @author
 * @date 2018-07-12 14:42
 **/
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Alias {

    String value();

}
