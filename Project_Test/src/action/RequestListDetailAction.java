package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AdminGibuDetailService;
import svc.RequestListDetailService;
import vo.ActionForward;
import vo.GibuDetailBean;
import vo.PageInfo;
import vo.RequestBean;
import vo.StockBean;

public class RequestListDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<StockBean> rdStockList = new ArrayList<StockBean>();
//		StockBean rdStock = new StockBean();
		HttpSession session = request.getSession();
		RequestBean requestBean = new RequestBean();
		int re_idx = Integer.parseInt(request.getParameter("re_idx"));
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		RequestListDetailService requestListDetailService = new RequestListDetailService();
		int listCount = requestListDetailService.getRdListCount();
		
		rdStockList = requestListDetailService.getRdStockList(page,limit, re_idx, requestBean);
		

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
		request.setAttribute("re_idx", re_idx);
		request.setAttribute("pageInfo", pageInfo);
		session.setAttribute("rdStockList", rdStockList);
		request.setAttribute("requestBean", requestBean);
		
	
		ActionForward forward = new ActionForward();
		forward.setPath("/jsp/request_detail_list.jsp");
		
		return forward;
	}

}
