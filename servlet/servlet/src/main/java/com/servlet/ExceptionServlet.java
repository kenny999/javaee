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

@WebServlet(value = "cookieservlet")
public class ExceptionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String r = "";

		String param = req.getParameter("type");
		if (param != null) {
			if (param.equals("addCookie")) {
				Cookie cookie = new Cookie("COOKIENAME", "COOKIEVALUE");
				resp.addCookie(cookie);
			}
			if (param.equals("removeCookie")) {
				Cookie[] cookies = req.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("COOKIENAME")) {
							cookie.setMaxAge(0);
							resp.addCookie(cookie);
						}
					}
				}
			}
			if (param.equals("readCookie")) {
				Cookie[] cookies = req.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("COOKIENAME")) {
							r = "Found cookie:" + cookie.getValue();
						}
					}
				}				
			}
		}

		resp.getWriter().println(r);
	}

}
