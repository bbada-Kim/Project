package J_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;
import J_svc.BoardDetailService;
import J_vo.BoardBean;
import action.Action;

public class BoardDetailAction implements Action {

	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_num=1;
		
		ActionForward forward = null;
		if(request.getParameter("board_num") != null)
			board_num=Integer.parseInt(request.getParameter("board_num"));
		String page=request.getParameter("page");
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(board_num);
		request.setAttribute("page", page);
		request.setAttribute("article",article);
		HttpSession session = request.getSession();
		if(session.getAttribute("id").equals("admin")) {
			request.setAttribute("pagefile", "/board/qna_board_view.jsp");
			forward = new ActionForward("index_admin.jsp", false);
		}
		else {
			request.setAttribute("pagefile", "/board/qna_board_view.jsp");
			forward = new ActionForward("index.jsp", false);
		}
//		forward.setPath("/board/qna_board_view.jsp");
		return forward;
	}
}

