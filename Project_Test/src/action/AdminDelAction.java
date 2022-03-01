package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminDelService;
import vo.ActionForward;

public class AdminDelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;	
		int do_idx = Integer.parseInt(request.getParameter("do_idx"));
		int bc_idx = Integer.parseInt(request.getParameter("do_idx"));
		
		String nowPage = request.getParameter("page");
		AdminDelService adminDelService = new AdminDelService();
		
		boolean isDeleteSuccess = adminDelService.removeArticle(do_idx, bc_idx);
		if(!isDeleteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 실패'>");
			out.println("history.back();");
			out.println("</script>");
			out.close();		
		}
		else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("gibuAdminList.b?page="+nowPage);
		}
		return forward;
	}

}
