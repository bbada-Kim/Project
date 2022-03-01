package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.BloodListService;
import vo.ActionForward;
import vo.BloodBean;

public class BloodListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		BloodListService bloodListService = new BloodListService();
		BloodBean bloodBean = bloodListService.getBloodCount();
		request.setAttribute("bloodBean", bloodBean);
		HttpSession session = request.getSession();
		if(session.getAttribute("id").equals("admin")) {
			request.setAttribute("pagefile", "/jsp/blood_list.jsp");
			forward = new ActionForward("index_admin.jsp", false);
		}
		else {
			request.setAttribute("pagefile", "/jsp/blood_list.jsp");
			forward = new ActionForward("index.jsp", false);
		}
		return forward;
	}

}
