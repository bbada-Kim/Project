package J_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import J_svc.MemberLoginService;
import vo.ActionForward;
import J_vo.MemberBean;
import action.Action;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		MemberBean member = new MemberBean();
		
		member.setM_ID(request.getParameter("M_ID"));
		member.setM_PW(request.getParameter("M_PASSWD"));
		String id = member.getM_ID();
		MemberLoginService memberLoginService = new MemberLoginService();
		boolean loginResult = memberLoginService.login(member);

		ActionForward forward = null;
		if(loginResult) {
			if(id.equals("admin")) {
				forward = new ActionForward();
				session.setAttribute("id", member.getM_ID());
				forward.setRedirect(true);
				forward.setPath("menu_top_admin.jsp");
			}else {
				forward= new ActionForward();
				session.setAttribute("id", member.getM_ID());
				forward.setRedirect(true);
				forward.setPath("menu_top.jsp");
			}
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패');");
			out.println("location.href='jsp/loginForm.jsp';");
			out.println("</script>");
		}
		return forward;
	}

}
