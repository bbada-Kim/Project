package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GibuListModService;
import vo.ActionForward;
import vo.GibuBean;

public class GibuListModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		
		int do_idx = Integer.parseInt(request.getParameter("do_idx"));
		String do_status = request.getParameter("do_status");
		String page = request.getParameter("page");
		String id = request.getParameter("id");
		
		GibuBean gibuMod = new GibuBean();
		gibuMod.setDo_idx(do_idx);
		gibuMod.setDo_status(do_status);
		
		
		GibuListModService gibuListModService = new GibuListModService();
		boolean isUpdateSuccess = gibuListModService.gibuModify(gibuMod);
		
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
			forward.setPath("gibuList.b?do_idx="+do_idx+"&id="+id);

		}
		
		return forward;
	}

}
