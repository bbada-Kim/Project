package svc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.BloodDAO;

import static db.JdbcUtil_bl.*;
import vo.GibuBean;

public class AdminModService {

	public boolean isGibuStockUpdate(GibuBean gibuBean) {
		
		boolean isModifySuccess = false;
		Connection con = getConnection("blood");
		BloodDAO bloodDAO = BloodDAO.getInstance();
		bloodDAO.setConnection(con);
		
		int updateGibu = bloodDAO.updateGibuBean(gibuBean);
		
		if(updateGibu > 0) {
			commit(con);
			isModifySuccess = true;
		}
		else {
			rollback(con);
		}
		close(con);
		
		return isModifySuccess;
	}

}
