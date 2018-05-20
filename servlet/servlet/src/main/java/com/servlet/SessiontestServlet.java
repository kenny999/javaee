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
import javax.servlet.http.HttpSession;

@WebServlet(value = "sessiontest")
public class SessiontestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession dummy = req.getSession();

		String type = req.getParameter("type");
		if (type != null && type.equals("forward")) {
			req.getRequestDispatcher("jspmedlankar.jsp").forward(req, resp);
		} else if(type != null && type.equals("redirect")) {
			resp.sendRedirect("jspmedlankar.jsp");
		}

	}

}
