package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminDetailService;
import svc.AdminGibuDetailService;
import vo.ActionForward;
import vo.GibuDetailBean;
import vo.PageInfo;
import vo.StockBean;

public class AdminGibuDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<StockBean> giList = new ArrayList<StockBean>();
		GibuDetailBean gdb = new GibuDetailBean();
		int do_idx = Integer.parseInt(request.getParameter("do_idx"));
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		AdminGibuDetailService adminGibuDetailService = new AdminGibuDetailService();
		int listCount = adminGibuDetailService.getListCount();
		
		giList = adminGibuDetailService.getgiList(page,limit, do_idx);
		
		gdb = adminGibuDetailService.getGibuDetail(do_idx);

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
		request.setAttribute("giList", giList);
		request.setAttribute("gdb", gdb);
	
		ActionForward forward = new ActionForward();
		forward.setPath("/jsp/gibu_detail_list.jsp");
		
		return forward;
	}

}
