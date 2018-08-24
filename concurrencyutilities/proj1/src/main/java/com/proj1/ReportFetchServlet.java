package com.proj1;

import java.io.IOException;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reportfetch")
public class ReportFetchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		Future<?> reportResult = (Future<?>) req.getSession().getAttribute("reporttask");
		if(reportResult == null){
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
		if(! reportResult.isDone()){
			resp.sendError(HttpServletResponse.SC_NO_CONTENT);
			return;
		}
		resp.getWriter().append((String) req.getSession().getAttribute("reportresult"));
	}
            
}
