package kr.or.team4.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.team4.action.Action;
import kr.or.team4.action.ActionForward;
import kr.or.team4.dao.MemberDao;


public class update implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		   // 수정
    	MemberDao dao = new MemberDao();
    	request.setAttribute("member", dao.getMemberDtoListById(request.getParameter("id")));
    	
   	  	ActionForward forward = new ActionForward();
   	  	forward.setRedirect(false);
   	  	forward.setPath("/WEB-INF/views/edit.jsp");
   	  
       
		return forward;
	}

}
