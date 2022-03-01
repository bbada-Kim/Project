package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminGibuListDelService;
import vo.ActionForward;
import vo.GibuBean;

public class AdminGibuListDelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		
		int do_idx = Integer.parseInt(request.getParameter("do_idx"));
		String do_status = request.getParameter("do_status");
		GibuBean gibuBean = new GibuBean();
		gibuBean.setDo_idx(do_idx);
		gibuBean.setDo_status(do_status);
		
		AdminGibuListDelService adminGibuListDelService = new AdminGibuListDelService();
		boolean isUpdateSuccess = adminGibuListDelService.isGibuListDel(gibuBean);
		
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
			forward.setPath("adminGibuStatusDetail.b?do_idx="+do_idx);

		}
		
		return forward;
	}

}
