package kr.or.team4.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.team4.action.Action;
import kr.or.team4.action.ActionForward;
import kr.or.team4.dao.MemberDao;

public class loginok implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		// 로그인 여부 확인
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        
        MemberDao dao = new MemberDao();
        
        if(dao.getMemberDtoListById(id) != null) {
           if(dao.getMemberDtoListById(id).getPwd().equals(pwd)) {
               System.out.println(22);
              request.getSession().setAttribute("id", id);
              forward.setPath("/WEB-INF/views/main.jsp");
           }else {
               System.out.println(11);
               forward.setPath("/WEB-INF/views/login.jsp");
           }
        }else {
        	forward.setPath("/WEB-INF/views/register.jsp");
        }
		return forward;
	}

}
