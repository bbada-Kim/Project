package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.BloodChartService;
import vo.ActionForward;
import vo.ChartBean;

public class BloodChartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		BloodChartService bloodChartService = new BloodChartService();
		ChartBean chartBean = bloodChartService.getBloodChart();
		request.setAttribute("chartBean", chartBean);
		HttpSession session = request.getSession();

		if(session.getAttribute("id").equals("admin")) {
			request.setAttribute("pagefile", "/jsp/chart_list.jsp");
			forward = new ActionForward("index_admin.jsp", false);
		}
		else {
			request.setAttribute("pagefile", "/jsp/chart_list.jsp");
			forward = new ActionForward("index.jsp", false);
		}
			
		return forward;
	}

}
