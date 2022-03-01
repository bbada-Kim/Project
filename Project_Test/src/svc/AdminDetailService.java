package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BloodDAO;

import static db.JdbcUtil_bl.*;

import vo.GibuBean;
import vo.StockBean;

public class AdminDetailService {

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

	public ArrayList<GibuBean> getdoList(int page, int limit) {
		ArrayList<GibuBean> doList = null;
		Connection con = null;
		try {
			con = getConnection("blood");
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			doList = bloodDAO.selectDoList(page, limit);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		
		return doList;
	}

}
