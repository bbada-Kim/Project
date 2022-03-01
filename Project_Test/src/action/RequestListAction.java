package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GibuAdminListService;
import svc.RequestListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.RequestBean;
import vo.StockBean;

public class RequestListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<RequestBean> rbList = new ArrayList<RequestBean>();

		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		RequestListService requestListService = new RequestListService();
		int listCount = requestListService.getRbListCount();
		
		rbList = requestListService.getRequestList(page,limit);

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
		request.setAttribute("rbList", rbList);

		request.setAttribute("pagefile", "/jsp/request_list_view.jsp");
		ActionForward forward = new ActionForward("index_admin.jsp", false);
		
		return forward;
	}

}
