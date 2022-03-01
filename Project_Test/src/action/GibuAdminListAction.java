package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GibuAdminListService;
import vo.StockBean;
import vo.ActionForward;
import vo.PageInfo;

public class GibuAdminListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ArrayList<StockBean> gibuList = new ArrayList<StockBean>();

		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		GibuAdminListService gibuAdminListService = new GibuAdminListService();
		int listCount = gibuAdminListService.getListCount();
		
		gibuList = gibuAdminListService.getGibuList(page,limit);

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
		request.setAttribute("gibuList", gibuList);
		
		request.setAttribute("pagefile", "/jsp/gibu_admin_list.jsp");
		ActionForward forward = new ActionForward("index_admin.jsp", false);
		
		return forward;
	}

}
