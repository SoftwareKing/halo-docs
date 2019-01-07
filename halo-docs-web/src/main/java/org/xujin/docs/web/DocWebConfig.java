package org.xujin.docs.web;

import org.xujin.doc.core.Config;

import javax.servlet.ServletContext;

/**
 * doc web 配置
 *
 * @author  xujin
 * @date 2018-04-24 11:23
 **/
public interface DocWebConfig extends Config {

    String getName();

    ServletContext getServletContext();

}
