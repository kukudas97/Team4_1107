package kr.or.team4.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.team4.action.Action;
import kr.or.team4.action.ActionForward;
import kr.or.team4.dao.MemberDao;
import kr.or.team4.dto.MemberDto;
import kr.or.team4.service.alllist;
import kr.or.team4.service.delete;
import kr.or.team4.service.detail;
import kr.or.team4.service.loginok;
import kr.or.team4.service.registerOk;
import kr.or.team4.service.search;
import kr.or.team4.service.update;
import kr.or.team4.service.updateok;


@WebServlet("*.do")
public class MemberServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public MemberServlet() {
        super();
       
    }
   private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1. 한글 처리
//            request.setCharacterEncoding("UTF-8");
//            response.setCharacterEncoding("UTF-8");
            
            //2. 데이터 받기 (입력데이터 , command)
            String requestURI = request.getRequestURI();
            String contextPath = request.getContextPath();
            String urlcommand = requestURI.substring(contextPath.length());
            
            System.out.println(urlcommand);
            
            String viewpage = "";
            Action action = null;
            ActionForward forward = null;
            
            HttpSession session = request.getSession();
            PrintWriter out = response.getWriter();
            //3. 요청 서비스 판단 (command 값을 비교해서)
            //4. 데이터 저장 
            if(urlcommand.equals("/login.do")) {
               //로그인
                forward = new ActionForward();
                forward.setPath("/WEB-INF/views/login.jsp");
                forward.setRedirect(false);
//               viewpage="/WEB-INF/views/login.jsp";
               
               //session에 id 설정
            }else if(urlcommand.equals("/loginok.do")) {
            	action = new loginok();
            	forward = action.execute(request, response);
            }else if (urlcommand.equals("/logout.do")) {
            	request.getSession().invalidate();
            	out.print("<script>alert('로그아웃');</script>");
                forward = new ActionForward();
                forward.setPath("/WEB-INF/views/main.jsp");
                forward.setRedirect(false);
            }
            else if(urlcommand.equals("/register.do")) {
               // 회원가입
                forward = new ActionForward();
                forward.setPath("/WEB-INF/views/register.jsp");
                forward.setRedirect(false);
            } else if(urlcommand.equals("/registerok.do")) {
               // 회원가입
               action = new registerOk();
               forward = action.execute(request, response);
            } else if(urlcommand.equals("/alllist.do")) {
               // 전체조회
            	action = new alllist();
            	forward=action.execute(request, response);
            	System.out.println(forward.getPath());
               // request.setAttribute("list",여기에값)
            } else if (urlcommand.equals("/main.do")) {
                forward = new ActionForward();
                forward.setPath("/WEB-INF/views/main.jsp");
                forward.setRedirect(false);
             } 
            else if(urlcommand.equals("/search.do")) {
               // like조회
               MemberDao dao = new MemberDao();
               
               request.setAttribute("list", dao.getMemberDtoByLikeEmail(request.getParameter("search")));
               
               viewpage = "/WEB-INF/views/list.jsp";
               // request.setAttribute("list",여기에값)
            } else if(urlcommand.equals("/update.do")) {
               // 수정
            	action = new update();
            	forward = action.execute(request, response);
               //수정 후 전체조회로
            } else if(urlcommand.equals("/updateok.do")) {
               // 수정
            	action = new updateok();
            	forward = action.execute(request, response);
            } else if(urlcommand.equals("/delete.do")) {
            	action = new delete();
                forward = action.execute(request, response);
            } else if(urlcommand.equals("/detail.do")){
               action = new detail();
               forward = action.execute(request, response);
            } else if (urlcommand.equals("/test.do")){
            	// like조회
                action = new search();
                forward = action.execute(request, response);
                // request.setAttribute("list",여기에값)
            }

			if(forward != null) {
				if(forward.isRedirect()) { //redirect
					response.sendRedirect(forward.getPath());
				} else {
					RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
					
					dis.forward(request, response);
				}
			}
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response);
   }

}