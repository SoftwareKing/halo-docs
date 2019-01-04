package org.xujin.halo.docs.starter;

import java.lang.annotation.*;

/**
 * Filter Init Parameter
 *
 * @author
 * @date 2018-08-08 10:39
 **/
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Param {

    /**
     * @return Filter Init Parameter Name
     */
    String name();

    /**
     * @return Filter Init Parameter Value
     */
    String value();

}
