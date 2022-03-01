package J_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import J_svc.MemberViewService;
import vo.ActionForward;
import J_vo.MemberBean;
import action.Action;

public class MemberViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		ActionForward forward= null;
		if(id == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/jsp/loginForm.jsp");
		}else if(!id.equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자가 아닙니다')");
			out.println("location.href='/jsp/loginForm.jsp';");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			String viewId = request.getParameter("id");
			MemberViewService memberViewService = new MemberViewService();
			MemberBean member = memberViewService.getMember(viewId);
			request.setAttribute("member", member);
			
			request.setAttribute("pagefile", "/member/member_info.jsp");
			forward = new ActionForward("index_admin.jsp",false);
		}
		return forward;
	}

}
