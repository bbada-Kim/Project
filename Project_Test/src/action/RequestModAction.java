package action;

import java.io.PrintWriter;
//import java.sql.*;
//import java.util.ArrayList;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import svc.RequestModService;
import vo.ActionForward;
import vo.StockBean;

public class RequestModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ActionForward forward =null;
		
		HttpSession session = request.getSession();
//		ArrayList<StockBean> requestGiveList = (ArrayList<StockBean>) session.getAttribute("requestGiveList");
		int rglCount = (Integer)session.getAttribute("rglCount");
		
		int re_idx = Integer.parseInt(request.getParameter("re_idx"));
		String[] checkList = request.getParameterValues("idx");
		int re_count = Integer.parseInt(request.getParameter("re_count"));
		
		if(checkList.length > re_count || re_count <= rglCount) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('선택한 헌혈증 개수가 요청 개수보다 많습니다.')");
			out.println("history.back();");
			out.println("</script>");
		}else {
		RequestModService requestModService = new RequestModService();
		boolean isUpdateSuccess = requestModService.reconfirm(request, checkList, re_idx);
		
		
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
			forward.setPath("requestListDetail.b?re_idx="+re_idx);
		}
	
		
		}
		return forward;
	}

}
