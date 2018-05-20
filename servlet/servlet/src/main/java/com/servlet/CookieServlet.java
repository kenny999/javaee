package com.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "exceptionservlet")
public class CookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String param = req.getParameter("type");
		if(param != null) {
			if(param.equals("NullPointerException")) {
				throw new NullPointerException();
			}
			if(param.equals("ServletException")) {
				Throwable rootCause = new IllegalArgumentException("my IllegalArgumentException");
				throw new ServletException(rootCause);
			}
			if(param.equals("UnavailableException")) {
				throw new UnavailableException("hello world");
			}
		}
	}

}
