package J_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import J_svc.MemberJoinService;
import vo.ActionForward;
import J_vo.MemberBean;
import action.Action;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberBean member = new MemberBean();
		boolean joinResult = false;
		
		member.setM_ID(request.getParameter("M_ID"));
		member.setM_PW(request.getParameter("M_PASSWD"));
		member.setM_NAME(request.getParameter("M_NAME"));
		member.setM_AGE(Integer.parseInt(request.getParameter("M_AGE")));
		member.setM_BLOOD(request.getParameter("M_BLOOD"));
		member.setM_ADDR(request.getParameter("M_ADDR"));
		member.setM_PHONE(request.getParameter("M_PHONE"));
		member.setM_GENDER(request.getParameter("M_GENDER"));
		member.setM_EMAIL(request.getParameter("M_EMAIL"));
		
		MemberJoinService memberJoinService = new MemberJoinService();
		joinResult = memberJoinService.joinMember(member);
		
		ActionForward forward = null;
		if(joinResult == false) {
			response.setContentType("text/html charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원등록')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("jsp/loginForm.jsp");
		}
		return forward;
	}

}
