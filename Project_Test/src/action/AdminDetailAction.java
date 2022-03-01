package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminDetailService;
import svc.GibuAdminListService;
import vo.ActionForward;
import vo.GibuBean;
import vo.PageInfo;
import vo.StockBean;

public class AdminDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ArrayList<GibuBean> doList = new ArrayList<GibuBean>();

		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		AdminDetailService adminDetailService = new AdminDetailService();
		int listCount = adminDetailService.getListCount();
		
		doList = adminDetailService.getdoList(page,limit);

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
		request.setAttribute("doList", doList);
		
		request.setAttribute("pagefile", "/jsp/admin_list_view.jsp");
		ActionForward forward = new ActionForward("index_admin.jsp", false);
		
		return forward;
	}

}
