package J_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import J_svc.MemberDeleteService;
import action.Action;
import vo.ActionForward;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ActionForward forward = null;
		if(id == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("jsp/loginForm.jsp");
		}else if(!id.equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자가 아닙니다');");
			out.println("location.href='jsp/loginForm.jsp';");
			out.println("</script>");
		}else {
			request.setAttribute("pagefile", "/memberListAction.me");
			forward = new ActionForward("index_admin.jsp",false);
			String deleteId =request.getParameter("id");
			MemberDeleteService memberDeleteService = new MemberDeleteService();
			boolean deleteResult = memberDeleteService.deleteMember(deleteId);
			
			if(deleteResult) {
				
				request.setAttribute("pagefile", "/memberListAction.me");
				forward = new ActionForward("index_admin.jsp",false);
				
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원정보 삭제 실패');");
				out.println("location.href='jsp/loginForm.jsp';");
				out.println("</script>");
			}
		}
		return forward;
	}

}
