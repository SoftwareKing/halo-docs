package org.xujin.docs.web;

import org.xujin.doc.core.Config;

import javax.servlet.ServletContext;

/**
 * Httpdoc web 配置
 *
 * @author
 * @date 2018-04-24 11:23
 **/
public interface HttpdocWebConfig extends Config {

    String getName();

    ServletContext getServletContext();

}
