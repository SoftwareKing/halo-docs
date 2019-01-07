package org.xujin.docs.web;

import javax.servlet.*;
import java.io.IOException;

/**
 * 文档中心默认Filter入口
 * @author
 * @date 2018-04-20 12:13
 **/
public class DocFilter extends HttpdocWebSupport implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        super.init(new DocFilterConfig(config));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        super.handle(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
