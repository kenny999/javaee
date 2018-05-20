package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "printbackservlet")
public class PrintBackServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	doBody(req, resp);
    }

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doBody(req, resp);
    	resp.getWriter().println(getBody(req));
	}

	public static String getBody(HttpServletRequest request) throws IOException {

	    String body = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = null;

	    try {
	        InputStream inputStream = request.getInputStream();
	        if (inputStream != null) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
	        } else {
	            stringBuilder.append("");
	        }
	    } catch (IOException ex) {
	        throw ex;
	    } finally {
	        if (bufferedReader != null) {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {
	                throw ex;
	            }
	        }
	    }

	    body = stringBuilder.toString();
	    return body;
	}
	
	private void doBody(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String result = "";
    	result += "<h2>Parameters</h2><br>\n";

    	String a = req.getParameter("a");
    	String b = req.getParameter("b");
    	
    	result += "a:"+a+"<br>\n";
    	result += "b:"+b+"<br>\n";
    	
    	String[] aValues = req.getParameterValues("a");
    	if(aValues != null) {
    		for(String aValue : aValues) {
    	    	result += "Again a:"+aValue+"<br>\n";    			
    		}
    	}

    	Enumeration<String> pNames = req.getParameterNames();
    	while(pNames.hasMoreElements()) {
    		String pName = pNames.nextElement();
	    	result += "A parameter name:"+pName+"<br>\n";
    	}
    	
    	Map<String, String[]> pMap = req.getParameterMap();
    	for(String pMapKey : pMap.keySet()) {
	    	result += "A key in parameter map:"+pMapKey+"<br>\n";
	    	String[] pmapkeyValues = pMap.get(pMapKey);
	    	if(pmapkeyValues != null) {
	    		for(String pmapkeyValue : pmapkeyValues) {
	    	    	result += "A value in parameter map for key "+pMapKey +":"+pmapkeyValue+"<br>\n";	    			
	    		}
	    	}    		
    	}
    	
    	result += "<br>\n";
    	result += "<h2>Headers</h2><br>\n";
    	
    	Enumeration<String> headerNames = req.getHeaderNames();
    	while(headerNames.hasMoreElements()) {
    		String headerName = headerNames.nextElement();
	    	String headerValue = req.getHeader(headerName);
	    	result += headerName+":"+headerValue+"<br>\n";
    	}
    	
    	result += "<h2>Attributes</h2><br>\n";
    	Enumeration<String> attributeNames = req.getAttributeNames();
    	while(attributeNames.hasMoreElements()) {
    		String attributeName = attributeNames.nextElement();
    		String attributeValue = (String) req.getAttribute(attributeName);
	    	result += attributeName+":"+attributeValue+"<br>\n";
    	}
    	
    	result += "<h2>AuthType</h2><br>\n";
    	String authType = req.getAuthType();
    	result += authType+"<br>\n";

    	result += "<h2>CharacterEncoding</h2><br>\n";

    	String characterEnc = req.getCharacterEncoding();
    	result += characterEnc+"<br>\n";
    	
    	result += "<h2>Content...</h2><br>\n";

    	int contentLength = req.getContentLength();
    	String contentType = req.getContentType();
    	result += "contentLength:"+contentLength+"<br>\n";
    	result += "contentType:"+contentType+"<br>\n";
    	
    	result += "<h2>Path</h2><br>\n";
    	String contextPath = req.getContextPath();
    	String servletPath = req.getServletPath();
    	String pathInfo = req.getPathInfo();
    	String pathTranslated = req.getPathTranslated();
    	result += "contextPath:"+contextPath+"<br>\n";
    	result += "servletPath:"+servletPath+"<br>\n";
    	result += "pathInfo:"+pathInfo+"<br>\n";
    	result += "pathTranslated:"+pathTranslated+"<br>\n";

    	result += "<h2>Cookies</h2><br>\n";
    	Cookie[] cookies = req.getCookies();
    	if(cookies != null) {
    		for(Cookie cookie : cookies) {
    	    	result += cookie.getName()+":"+cookie.getValue()+"<br>\n";
    			
    		}
    	}
    	
    	result += "<h2>Misc</h2><br>\n";
    	result += "dispatcherType:"+ req.getDispatcherType()+"<br>\n";
    	
    	result += "localAddr:" + req.getLocalAddr()+"<br>\n";
    	result += "localName:" + req.getLocalName()+"<br>\n";
    	result += "LocalPort:" + req.getLocalPort()+"<br>\n";
    	result += "Locale:" + req.getLocale()+"<br>\n";
    	result += "Method:" + req.getMethod()+"<br>\n";
    	result += "Protocol:" + req.getProtocol()+"<br>\n";
    	result += "RemoteHost:" + req.getRemoteHost()+"<br>\n";
    	result += "RemotePort:" + req.getRemotePort()+"<br>\n";
    	result += "RemoteUser:" + req.getRemoteUser()+"<br>\n";
    	result += "RemoteAddr:" + req.getRemoteAddr()+"<br>\n";
    	result += "Scheme:" + req.getScheme()+"<br>\n";
    	result += "UserPrincipal:" + req.getUserPrincipal()+"<br>\n";
    	result += "ServerPort:" + req.getServerPort()+"<br>\n";
    	result += "ServerName:" + req.getServerName()+"<br>\n";
    	result += "QueryString:" + req.getQueryString()+"<br>\n";
    	result += "Session:" + req.getSession(false)+"<br>\n";
    	result += "RequestURL:" + req.getRequestURL()+"<br>\n";
    	result += "RequestURI:" + req.getRequestURI()+"<br>\n";
    	result += "RequestedSessionId:" + req.getRequestedSessionId()+"<br>\n";
    	
    	
    	resp.getWriter().println(result);
	}
	
	@Override
	public void init() {
		System.out.println("init called in servlet");
	}
	@Override
	public void destroy() {
		System.out.println("destroy called in servlet");
	}

}
