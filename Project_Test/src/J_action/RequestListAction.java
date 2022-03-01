package J_action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import J_svc.RequestListService;
import vo.ActionForward;
import J_vo.BloodReBean;
import vo.PageInfo;
import action.Action;
public class RequestListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<BloodReBean> bloodReList = new ArrayList<BloodReBean>();
		RequestListService requestListService = new RequestListService();
		BloodReBean bloodReBean = new BloodReBean();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		bloodReBean.setID(id);
		String gid = bloodReBean.getID();
		int page = 1;
		int limit = 10;
		System.out.println(gid);
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int listCount =requestListService.getGibuListCount(gid);
		
		bloodReList = requestListService.getRequestList(page, limit, gid);
		
		int maxPage = (int) ((double)listCount/limit+0.95);
		
		int startPage = (((int)((double)page / 10+0.9))-1) * 10 + 1;
		
		int endPage = startPage + 10-1;
		
		if(endPage > maxPage) endPage = maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
			
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("bloodReList", bloodReList);
		request.setAttribute("id", gid);
		
//		ActionForward forward = new ActionForward();
		
		request.setAttribute("pagefile", "/jsp/bloodView.jsp");
		ActionForward forward = new ActionForward("index.jsp", false);
//		forward.setPath("bloodView.jsp");
		
		return forward;
	}

}
