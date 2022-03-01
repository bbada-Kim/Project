package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import J_action.MemberDeleteAction;
import J_action.MemberJoinAction;
import J_action.MemberListAction;
import J_action.MemberLoginAction;
import J_action.MemberViewAction;
import vo.ActionForward;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.me")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		//1.요청평가
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
	
		
		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;
		
		//2.각 요청별로 비즈니스 로직 호출
		if(command.equals("/memberLogin.me")) {
			forward=new ActionForward();
			request.setAttribute("pagefile","/jsp/loginForm.jsp");
			forward.setPath("index.jsp");
		}else if(command.equals("/memberJoin.me")) {
			forward=new ActionForward();
			forward.setPath("/jsp/joinForm.jsp");
	}else if(command.equals("/memberLoginAction.me")) {
			action = new MemberLoginAction();
			try {
				forward = action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/memberJoinAction.me")) {
			action = new MemberJoinAction();
			try {
				forward = action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/memberListAction.me")) {
			action = new MemberListAction();
			try {
				forward = action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/memberViewAction.me")) {
			action = new MemberViewAction();
			try {
				forward = action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/memberDeleteAction.me")) {
			action = new MemberDeleteAction();
			try {
				forward = action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//3.포워딩
		if(forward !=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
