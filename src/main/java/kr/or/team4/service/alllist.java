package kr.or.team4.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.team4.action.Action;
import kr.or.team4.action.ActionForward;
import kr.or.team4.dao.MemberDao;
import kr.or.team4.dto.MemberDto;

public class alllist implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		  // 전체조회
		MemberDao dao = new MemberDao();
        List<MemberDto> MemberDtolist = dao.getAllMemberDtoList();
        request.setAttribute("MemberDtolist", MemberDtolist);
        
        forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/list");
        
		return forward;
	}

}
