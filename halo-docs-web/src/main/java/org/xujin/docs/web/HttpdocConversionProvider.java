package org.xujin.docs.web;

import org.xujin.docs.web.conversion.*;

import java.util.Arrays;

/**
 * 配置类转换提供器
 *
 * @author
 * @date 2018-06-27 10:27
 **/
public class HttpdocConversionProvider extends StandardConversionProvider {

    public HttpdocConversionProvider() {
        super(Arrays.<Converter>asList(
                //基本类似转换
                new PrimaryConverter(),
                //包装类型转换
                new WrapperConverter(),
                //数字类型转换
                new NumberConverter(),
                //字符串类型转换
                new StringConverter(),
                //日期类型转换
                new DateConverter(),
                //枚举类型转换
                new EnumConverter(),
                //数组类型转换
                new ArrayConverter(),
                //List类型转换
                new ListConverter(),
                //Set集合类型转换
                new SetConverter(),
                //Map类型转换
                new MapConverter()
        ));
    }

}
