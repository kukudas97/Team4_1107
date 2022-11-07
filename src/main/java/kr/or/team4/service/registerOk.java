package kr.or.team4.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.team4.action.Action;
import kr.or.team4.action.ActionForward;
import kr.or.team4.dao.MemberDao;
import kr.or.team4.dto.MemberDto;

public class registerOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		  String resultdata="";
		  
           String id = request.getParameter("id");
           String pwd = request.getParameter("pwd");
           String name = request.getParameter("name");
           int age = Integer.parseInt(request.getParameter("age"));
           String gender = request.getParameter("gender");
           String email = request.getParameter("email");
           String ip = request.getRemoteAddr();
   
           MemberDao dao = new MemberDao();
         
           MemberDto dto = new MemberDto(id, pwd, name, age, gender, email, ip);
           int row = dao.insertMemberDto(dto);
           if(row>0) {
               resultdata = "welcome to kosa" + dto.getId()+"님";
            }else {
               resultdata = "Insret fail";
            }
           request.setAttribute("data", resultdata);
           
           ActionForward forward = new ActionForward();
           forward.setRedirect(false);
           forward.setPath("WEB-INF/views/register.jsp");
           
		return forward;
	}

}
