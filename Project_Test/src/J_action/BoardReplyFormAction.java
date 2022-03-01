package J_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import J_svc.BoardDetailService;
import vo.ActionForward;
import J_vo.BoardBean;
import action.Action;
public class BoardReplyFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ActionForward forward = null;
		String nowPage =request.getParameter("page");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(board_num);
		request.setAttribute("article",article);
		request.setAttribute("page", nowPage);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("id").equals("admin")) {
			request.setAttribute("pagefile", "/board/qna_board_reply.jsp");
			forward = new ActionForward("index_admin.jsp", false);
		}
		else {
			request.setAttribute("pagefile", "/board/qna_board_reply.jsp");
			forward = new ActionForward("index.jsp", false);
		}
//		forward.setPath("/board/qna_board_reply.jsp");
		return forward;
	}

}
