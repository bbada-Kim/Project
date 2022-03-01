package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminGibuDetailModService;
import vo.ActionForward;
import vo.GibuBean;

public class AdminGibuDetailModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		int do_idx = Integer.parseInt(request.getParameter("do_idx"));
		String nowPage = request.getParameter("page");
		System.out.println(c_idx);
		
//		GibuBean gibuBean = new GibuBean();
//		gibuBean.setDo_idx(do_idx);
	
		AdminGibuDetailModService adminGibuDetailModService = new AdminGibuDetailModService();
		boolean isUpdateSuccess = adminGibuDetailModService.isInStockUpdate(c_idx);
		
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
			forward.setPath("adminGibuDetail.b?do_idx="+do_idx);

		}
		
		return forward;
	}

}
