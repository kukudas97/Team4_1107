package kr.or.team4.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.team4.action.Action;
import kr.or.team4.action.ActionForward;
import kr.or.team4.dao.MemberDao;
import kr.or.team4.dto.MemberDto;

public class delete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		try {
			MemberDao dao = new MemberDao();
			dao.deleteMemberDto(request.getParameter("id"));
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/alllist.do");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

}
