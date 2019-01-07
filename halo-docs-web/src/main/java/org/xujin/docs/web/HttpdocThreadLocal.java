package org.xujin.docs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 线程本地变量
 *
 * @author
 **/
public class HttpdocThreadLocal {

    private static final ThreadLocal<HttpServletRequest> REQUEST = new ThreadLocal<>();
    private static final ThreadLocal<HttpServletResponse> RESPONSE = new ThreadLocal<>();

    public static HttpServletRequest getRequest() {
        return REQUEST.get();
    }

    public static HttpServletResponse getResponse() {
        return RESPONSE.get();
    }

    static void bind(HttpServletRequest request, HttpServletResponse response) {
        REQUEST.set(request);
        RESPONSE.set(response);
    }

    static void clear() {
        REQUEST.remove();
        RESPONSE.remove();
    }

}
