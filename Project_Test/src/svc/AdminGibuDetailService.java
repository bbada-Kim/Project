package svc;

import static db.JdbcUtil_bl.close;
import static db.JdbcUtil_bl.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BloodDAO;
import vo.GibuBean;
import vo.GibuDetailBean;
import vo.StockBean;

public class AdminGibuDetailService {

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

	public ArrayList<StockBean> getgiList(int page, int limit, int do_idx) {
		ArrayList<StockBean> giList = null;
		
		Connection con = null;
		try {
			con = getConnection("blood");
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			giList = bloodDAO.selectGiList(page, limit, do_idx);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		
		return giList;
	}

	public GibuDetailBean getGibuDetail(int do_idx) {
		GibuDetailBean gdb = null;
		
		Connection con = null;
		try {
			con = getConnection("blood");
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			gdb = bloodDAO.selectGiStock(do_idx);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return gdb;
	}

}
