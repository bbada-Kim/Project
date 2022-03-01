package svc;

import java.sql.Connection;

import dao.BloodDAO;

import static db.JdbcUtil_bl.*;
import vo.GibuBean;

public class AdminGibuListDelService {

	public boolean isGibuListDel(GibuBean gibuBean) {

		boolean isModifySuccess = false;
		Connection con = getConnection("blood");
		BloodDAO bloodDAO = BloodDAO.getInstance();
		bloodDAO.setConnection(con);
		
		int updateGibu = bloodDAO.updateGibuDel(gibuBean);
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
