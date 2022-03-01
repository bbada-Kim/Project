package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BloodDAO;

import static db.JdbcUtil_bl.*;
import vo.RequestBean;
import vo.StockBean;

public class RequestListService {

	public int getRbListCount() {
		int listCount = 0;
		Connection con = null;
		try {
			con = getConnection("blood");
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			listCount = bloodDAO.selectRbListCount();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return listCount;
	}
	

	public ArrayList<RequestBean> getRequestList(int page, int limit) {
		ArrayList<RequestBean> list = null;
		Connection con = null;
		try {
			con = getConnection("blood");
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			list = bloodDAO.selectRequestList(page, limit);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return list;
	}

}
