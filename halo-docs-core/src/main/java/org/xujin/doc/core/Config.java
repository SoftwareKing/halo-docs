package org.xujin.doc.core;

import java.util.Enumeration;

/**
 * 配置
 * @author
 * 2018/11/12
 */
public interface Config {

    String getInitParameter(String name);

    Enumeration<String> getInitParameterNames();

}
