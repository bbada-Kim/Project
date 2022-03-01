package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AdminDetailService;
import svc.RequestGiveListService;
import vo.ActionForward;
import vo.GibuBean;
import vo.PageInfo;
import vo.StockBean;

public class RequestGiveListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<StockBean> requestGiveList = new ArrayList<StockBean>();
		
		HttpSession session = request.getSession();
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int re_idx = Integer.parseInt(request.getParameter("re_idx"));
		
		RequestGiveListService requestGiveListService = new RequestGiveListService();
		int listCount = requestGiveListService.getListCount();
		
		requestGiveList = requestGiveListService.getRequestGiveList(request ,page,limit, re_idx);


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
		int rglCount = requestGiveList.size();
		request.setAttribute("pageInfo", pageInfo);
		session.setAttribute("requestGiveList", requestGiveList);
		session.setAttribute("rglCount", rglCount);
		System.out.println(rglCount);
	
		ActionForward forward = new ActionForward();
		forward.setPath("/jsp/request_give_list.jsp");
		return forward;
	}

}
