package svc;

import static db.JdbcUtil_bl.close;
import static db.JdbcUtil_bl.commit;
import static db.JdbcUtil_bl.getConnection;
import static db.JdbcUtil_bl.rollback;

import java.sql.Connection;

import dao.BloodDAO;
import vo.GibuBean;

public class AdminGibuDetailModService {

	public boolean isInStockUpdate(int c_idx) {
		boolean isInStockModSuccess = false;
		Connection con = getConnection("blood");
		BloodDAO bloodDAO = BloodDAO.getInstance();
		bloodDAO.setConnection(con);
		
		int updateStockStatus = bloodDAO.updateInStockStatus(c_idx);
		
		if(updateStockStatus > 0) {
			commit(con);
			isInStockModSuccess = true;
		}
		else {
			rollback(con);
		}
		close(con);
		
		return isInStockModSuccess;		
	}

}
