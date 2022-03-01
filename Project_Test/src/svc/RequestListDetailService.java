package svc;

import static db.JdbcUtil_bl.close;
import static db.JdbcUtil_bl.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BloodDAO;
import vo.RequestBean;
import vo.StockBean;

public class RequestListDetailService {

	public int getRdListCount() {
		int listCount = 0;
		Connection con = null;
		try {
			con = getConnection("blood");
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			listCount = bloodDAO.selectRdListCount();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return listCount;
	}
	
	public ArrayList<StockBean> getRdStockList(int page, int limit, int re_idx, RequestBean requestBean) {
		ArrayList<StockBean> rdStockList = null;
		
		Connection con = null;
		try {
			con = getConnection("blood");
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			rdStockList = bloodDAO.selectRdStockList(page, limit);
			requestBean = bloodDAO.selectRequestBean(requestBean, re_idx);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		
		return rdStockList;
	}
}
