package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import J_action.BoardDeleteProAction;
import J_action.BoardDetailAction;
import J_action.BoardListAction;
import J_action.BoardModifyFormAction;
import J_action.BoardModifyProAction;
import J_action.BoardReplyFormAction;
import J_action.BoardReplyProAction;
import J_action.BoardWriteProAction;
import vo.ActionForward;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		HttpSession session = request.getSession();
		System.out.println(command);
		if (command.equals("/boardWriteForm.bo")) {
			String id = request.getParameter("id");
			
			if(session.getAttribute("id").equals("admin")) {
				request.setAttribute("pagefile","/board/qna_board_write.jsp");
				request.setAttribute("id", id);
				forward = new ActionForward();
				forward.setPath("index_admin.jsp");
			}
			else {
				request.setAttribute("pagefile","/board/qna_board_write.jsp");
				request.setAttribute("id", id);
				forward = new ActionForward();
				forward.setPath("index.jsp");
			}
			System.out.println(id);
		} else if (command.equals("/boardWritePro.bo")) {
			action = new BoardWriteProAction();
			try { 
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardList.bo")) {
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDetail.bo")) {
			action = new BoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardReplyForm.bo")) {
			action = new BoardReplyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/boardReplyPro.bo")) {
			action = new BoardReplyProAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardModifyForm.bo")) {
			action = new BoardModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardModifyPro.bo")) {
			action = new BoardModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/boardDeleteForm.bo"))	{
			String board_num = request.getParameter("board_num");
			String page=request.getParameter("page");
			
			request.setAttribute("board_num", board_num);
			request.setAttribute("page", page);
			
			if(session.getAttribute("id").equals("admin")) {
				forward = new ActionForward("index_admin.jsp", false);
				request.setAttribute("pagefile", "/board/qna_board_delete.jsp");
			}
			else {
				forward = new ActionForward("index.jsp", false);
				request.setAttribute("pagefile", "/board/qna_board_delete.jsp");
			}
		}else if(command.equals("/boardDeletePro.bo")) {
			action = new BoardDeleteProAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
