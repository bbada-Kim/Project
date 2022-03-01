package svc;

import java.sql.Connection;
import java.util.ArrayList;
import dao.BloodDAO;
import static db.JdbcUtil_bl.*;
import vo.StockBean;

public class GibuAdminListService {

	public int getListCount() {
		
		int listCount = 0;
		Connection con = null;
		try {
			con = getConnection("blood");
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			listCount = bloodDAO.selectListCount();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return listCount;
	}

	
//-------------------------------- 재고 테이블에 접근하는 부분 --------------------------------			
	public ArrayList<StockBean> getGibuList(int page, int limit) {
		ArrayList<StockBean> list = null;
		Connection con = null;
		try {
			con = getConnection("blood");
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			list = bloodDAO.selectgibuList(page, limit);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return list;
	}
	
}
