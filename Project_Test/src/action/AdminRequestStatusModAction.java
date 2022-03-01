package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminRequestStatusModService;
import vo.ActionForward;
import vo.RequestBean;

public class AdminRequestStatusModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		int re_idx = Integer.parseInt(request.getParameter("re_idx"));
		String re_status = request.getParameter("re_status");
		RequestBean requestBean = new RequestBean();
		requestBean.setRe_idx(re_idx);
		requestBean.setRe_status(re_status);
		
		AdminRequestStatusModService adminRequestStatusModService = new AdminRequestStatusModService();
		boolean isUpdateSuccess = adminRequestStatusModService.isRequestStatusUpdate(requestBean);
		
		if(!isUpdateSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 실패')");
			out.println("history.back();");
			out.println("</script>");			
		}
		else {
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("adminRequestStatusModForm.b?re_idx="+re_idx);

		}
		return forward;
	}

}
