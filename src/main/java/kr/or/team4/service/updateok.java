package kr.or.team4.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.team4.action.Action;
import kr.or.team4.action.ActionForward;
import kr.or.team4.dao.MemberDao;
import kr.or.team4.dto.MemberDto;


/*
 * 	private boolean isRedirect = false; //뷰의 전환 여부 redirect or forward
	private String path = null;	//이동 경로
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
 */

public class updateok implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
        // 수정
        MemberDao dao = new MemberDao();
                       
        MemberDto dto = new MemberDto();
        
        dto.setId(request.getParameter("id"));
        dto.setName(request.getParameter("name"));
        dto.setAge(Integer.parseInt(request.getParameter("age")));
        dto.setGender(request.getParameter("gender"));
        dto.setEmail(request.getParameter("email"));
        
        int result = 0;
        String msg = "";
        String url ="";
        
        result = dao.updateMemberDto(dto);
        
        if(result>0) {
        	//수정 성공
        	msg = "수정 성공";
        	url = "/alllist.do"; //수정성공하면 전체목록
        }else {
        	//수정 실패
        	msg = "수정 실패";
        	url = "/main.do"; //수정실패하면 메인
        }
        
        request.setAttribute("update_msg", msg);
        request.setAttribute("update_url", url);
        
        /*     
     //규칙 (성공,실패하던  msg 작성되고 조건에 이동하는 페이지가 생성)
  	  String msg="";
  	  String url="";
  	  if(result > 0) {
  		  msg="등록성공";
  		  url="MemoList.memo"; //요청 서블릿 주소
  	  }else {
  		  msg="등록실패";
  		  url="memo.html";
  	  }
  	  
  	  request.setAttribute("board_msg", msg);
  	  request.setAttribute("board_url", url);
        */
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/redirect.jsp");
		
		return forward;
	}

}
