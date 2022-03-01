package J_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import J_svc.BoardModifyFormSvc;
import vo.ActionForward;
import J_vo.BoardBean;
import action.Action;

public class BoardModifyFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");

		BoardModifyFormSvc boardModifyFromSvc = new BoardModifyFormSvc();
		BoardBean article = boardModifyFromSvc.getArticle(board_num);
		System.out.println("Action : "+article);
		request.setAttribute("article", article);
		request.setAttribute("page", page);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("id").equals("admin")) {
			forward = new ActionForward("index_admin.jsp", false);
			request.setAttribute("pagefile", "/board/qna_board_modify.jsp");
		}
		else {
			forward = new ActionForward("index.jsp", false);
			request.setAttribute("pagefile", "/board/qna_board_modify.jsp");
		}
//		forward.setPath("/board/qna_board_modify.jsp");
		return forward;

	}

}