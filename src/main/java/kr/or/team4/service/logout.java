package kr.or.team4.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.team4.action.Action;
import kr.or.team4.action.ActionForward;

public class logout implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		try {
            PrintWriter out = response.getWriter();
	    	request.getSession().invalidate();
	    	request.setAttribute("message", "logout");
	        forward = new ActionForward();
	        forward.setPath("/WEB-INF/createview/popup.jsp");
	        forward.setRedirect(false);
		}catch (Exception e) {
			System.out.println(e);
		}
		return forward;
	}

}
