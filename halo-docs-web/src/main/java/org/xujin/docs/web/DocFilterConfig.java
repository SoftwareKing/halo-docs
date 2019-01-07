package org.xujin.docs.web;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;

/**
 * Httpdoc Filter 配置
 *
 * @author
 * @date 2018-04-24 11:26
 **/
public class DocFilterConfig implements DocWebConfig {
    private final FilterConfig config;

    DocFilterConfig(FilterConfig config) {
        this.config = config;
    }

    @Override
    public String getName() {
        return config.getFilterName();
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
