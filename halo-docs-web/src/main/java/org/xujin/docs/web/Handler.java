package org.xujin.docs.web;

import org.xujin.doc.core.Document;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {

    void handle(Document document, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
