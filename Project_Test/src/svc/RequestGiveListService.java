package svc;

import static db.JdbcUtil_bl.close;
import static db.JdbcUtil_bl.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.BloodDAO;
import vo.GibuBean;
import vo.RequestBean;
import vo.StockBean;

public class RequestGiveListService {

	public int getListCount() {
		int listCount = 0;
		Connection con = null;
		try {
			con = getConnection("blood");
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			listCount = bloodDAO.selectDoListCount();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return listCount;
	}
	
	public ArrayList<StockBean> getRequestGiveList(HttpServletRequest request, int page, int limit, int re_idx) {
//		HttpSession session = request.getSession();
//		ArrayList<StockBean> requestGiveList = (ArrayList<StockBean>)session.getAttribute("requestGiveList");
		ArrayList<StockBean> requestGiveList = null;
		Connection con = null;
		try {
			con = getConnection("blood");
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			requestGiveList = bloodDAO.selectRequestGiveList(page, limit, re_idx);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		
		return requestGiveList;
	}



}
