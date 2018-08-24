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

@WebServlet("/reportsubmit")
public class ReportSubmitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Resource
	ManagedExecutorService managedExecutorService;
	
	@Inject
	ReportTask reportTask;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		String id = req.getParameter("id");
		if(id == null){
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		reportTask.setId(id);
		reportTask.setSession(req.getSession());
		
		String p = "http://localhost:8080" + req.getContextPath() + "/reportfetch";
		Future<?> result = managedExecutorService.submit(reportTask);
		req.getSession().setAttribute("reporttask", result);
		resp.getWriter().append(p);
	}
            
}
