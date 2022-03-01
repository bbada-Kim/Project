package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.MultiFileAction;
import action.RequestGiveListAction;
import vo.ActionForward;
import vo.StockBean;
import action.Action;
import action.AdminDetailAction;
import action.AdminGibuDelAction;
import action.AdminGibuDetailAction;
import action.AdminGibuDetailModAction;
import action.AdminGibuListDelAction;
import action.AdminModAction;
import action.AdminRequestStatusModAction;
import action.BloodChartAction;
import action.BloodListAction;
import action.GibuAdminListAction;
import action.GibuDetailAction;
import action.GibuListAction;
import action.GibuListModAction;
import action.GibuWriteAction;
import action.RequestListAction;
import action.RequestListDetailAction;
import action.RequestModAction;

@WebServlet("*.b")
public class BloodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String requestURI = request.getRequestURI();
		
		String contextPath = request.getContextPath();		
		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;	
//		if(command.equals("/bloodList.b")) {
//			request.setAttribute("pagefile", "/jsp/blood_list.jsp");
//			forward = new ActionForward();
//			forward.setPath("index.jsp");
//
//		}	
		if(command.equals("/bloodList.b")) {
			action = new BloodListAction();
		
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/chartList.b")) {
			action = new BloodChartAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/gibuWriteForm.b")) {
			request.setAttribute("pagefile", "jsp/gibu_write.jsp");
			forward = new ActionForward();
//			forward.setPath("file_upload_add.jsp");
			forward.setPath("index.jsp");
		}
		//기부신청페이지
		else if(command.equals("/gibuWrite.b")) {
			action = new GibuWriteAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/gibuAdminList.b")) {
			action = new GibuAdminListAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
//		else if(command.equals("/gibuDetailForm.b")) {
//			request.setAttribute("pagefile", "index_gibu.jsp");
//			forward = new ActionForward();
////			forward.setPath("file_upload_add.jsp");
//			forward.setPath("index.jsp");
//		}
		else if(command.equals("/gibuList.b")) {
			action = new GibuListAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/adminDetail.b")) {
			action = new AdminDetailAction();
			
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/adminGibuDetail.b")) {
			action = new AdminGibuDetailAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/adminListMod.b")) {
			action = new AdminModAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
//		else if(command.equals("/adminListDelForm.b")) {
//			String do_idx = request.getParameter("do_idx");
//			String page = request.getParameter("page");
//			
//			request.setAttribute("do_idx", do_idx);
//			request.setAttribute("page", page);
//			forward = new ActionForward();
//			forward.setPath("/jsp/admin_list_del.jsp");
//		}
		else if(command.equals("/adminGibuListDelForm.b")) {
			forward = new ActionForward();
			forward.setPath("/jsp/admin_gibulist_del.jsp");
		}
		else if(command.equals("/adminGibuListDel.b")) {
			action = new AdminGibuListDelAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/requestList.b")) {
			action = new RequestListAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/requestListMod.b")) {
			action = new RequestModAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/logoutForm.b")) {
			forward = new ActionForward();
			forward.setPath("/jsp/logout.jsp");
		}
		else if(command.equals("/imageAction.b")) {

			forward = new ActionForward();
			forward.setPath("jsp/image1.jsp");
		}
		else if(command.equals("/gibuListMod.b")) {
			action = new GibuListModAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/adminGibuStatusDetail.b")) {
			forward = new ActionForward();
			forward.setPath("/jsp/adminGibu_Status_Detail.jsp");
		}
		else if(command.equals("/adminGibuDetailMod.b")) {
			action = new AdminGibuDetailModAction();

			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/adminRequestStatusModForm.b")) {
			forward = new ActionForward();
			forward.setPath("/jsp/admin_request_status_mod.jsp");
		}
		else if(command.equals("/adminRequestStatusMod.b")) {
			action = new AdminRequestStatusModAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/requestListDetail.b")) {
			action = new RequestListDetailAction();
			
			try {
				forward=action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/gibuStatusDetail.b")) {
			forward = new ActionForward();
			forward.setPath("/jsp/gibu_Status_Detail.jsp");
		}
		else if(command.equals("/gibuDetail.b")){
			action = new GibuDetailAction();
			try {
				forward=action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/requestGiveList.b")) {
			action = new RequestGiveListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			
			}
		}
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
