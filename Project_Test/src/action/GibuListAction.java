package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.GibuListService;
import vo.ActionForward;
import vo.GibuBean;
import vo.PageInfo;
import vo.StockBean;

public class GibuListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<GibuBean> gibuList = new ArrayList<GibuBean>();
		GibuBean gibuBean = new GibuBean();
		HttpSession session = request.getSession();
		
		gibuBean.setId((String)session.getAttribute("id"));
		String gid = gibuBean.getId();
		
		int page = 1;
		int limit = 10;
		GibuListService gibuListService = new GibuListService();
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int listCount = gibuListService.getGibuListCount(gid);
		
		gibuList = gibuListService.getGibuBeanList(page, limit, gid);
		
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
		request.setAttribute("id", gid);
		request.setAttribute("pagefile", "/jsp/gibu_list.jsp");
		ActionForward forward = new ActionForward("index.jsp", false);
		
		return forward;
	}

}
