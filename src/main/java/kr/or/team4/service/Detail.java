package kr.or.team4.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.team4.action.Action;
import kr.or.team4.action.ActionForward;
import kr.or.team4.dao.MemberDao;

public class Detail implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward = new ActionForward();
		
        MemberDao dao = new MemberDao();
        
        request.setAttribute("member", dao.getMemberDtoListById(request.getParameter("id")));
        
        forward.setPath("/WEB-INF/views/detail.jsp");
        forward.setRedirect(false);
		return forward;
	}

}
