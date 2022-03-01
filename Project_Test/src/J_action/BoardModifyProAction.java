package J_action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import J_svc.BoardModifyProService;
import vo.ActionForward;
import J_vo.BoardBean;
import action.Action;

public class BoardModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		int board_num=Integer.parseInt(request.getParameter("BOARD_NUM"));
		String pass= request.getParameter("BOARD_PASS");
		String subject = request.getParameter("BOARD_SUBJECT");
		String content = request.getParameter("BOARD_CONTENT");
		String page = request.getParameter("page");
		BoardBean article=new BoardBean();
		BoardModifyProService boardModifyProService = new BoardModifyProService();
		boolean isRightUser=
				boardModifyProService.isArticleWriter(board_num, pass);

		if(!isRightUser){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			article.setBOARD_NUM(board_num);
			article.setBOARD_SUBJECT(subject);
			article.setBOARD_CONTENT(content); 
			isModifySuccess = boardModifyProService.modifyArticle(article);

			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back()");
				out.println("</script>");
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardDetail.bo?board_num="+board_num+"&page="+page);
			}

		}

		return forward;
	}

}