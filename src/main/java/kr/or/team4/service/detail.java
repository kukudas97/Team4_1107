package kr.or.team4.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.team4.action.Action;
import kr.or.team4.action.ActionForward;
import kr.or.team4.dao.MemberDao;
import kr.or.team4.dto.MemberDto;

public class detail implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
				
		try {
			String id = request.getParameter("id");
			MemberDao dao = new MemberDao();
			MemberDto dto = new MemberDto();
			
			dto = dao.getMemberDtoListById(id);
			request.setAttribute("member", dto);
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/detail.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
