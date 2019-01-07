package org.xujin.docs.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;

/**
 * Httpdoc Servlet 配置
 *
 * @author
 * @date 2018-04-24 11:27
 **/
public class DocServletConfig implements DocWebConfig {
    private final ServletConfig config;

    DocServletConfig(ServletConfig config) {
        this.config = config;
    }

    @Override
    public String getName() {
        return config.getServletName();
    }

    @Override
    public ServletContext getServletContext() {
        return config.getServletContext();
    }

    @Override
    public String getInitParameter(String name) {
        return config.getInitParameter(name);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return config.getInitParameterNames();
    }

}
