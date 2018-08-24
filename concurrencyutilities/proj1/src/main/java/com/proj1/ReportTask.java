package com.proj1;

import javax.enterprise.context.Dependent;
import javax.servlet.http.HttpSession;

@Dependent
public class ReportTask implements Runnable {

	private String id;
	String result;
	private HttpSession session;

	@Override
	public void run() {
		result = "";
		for(int i=0;i<30;i++){
			try {
				result += id + "\n";
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		session.setAttribute("reportresult", result);
		System.out.println("Done");		
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setSession(HttpSession session) {
		this.session = session;		
	}

}
