package svc;

import java.sql.Connection;

import dao.BloodDAO;

import static db.JdbcUtil_bl.*;
import vo.GibuBean;

public class GibuListModService {

	public boolean gibuModify(GibuBean gibuMod) {
		boolean isModifySuccess = false;
		Connection con = getConnection("blood");

		
		BloodDAO bloodDAO = BloodDAO.getInstance();
		bloodDAO.setConnection(con);
		int gibuModify = bloodDAO.gibuStatusMod(gibuMod);
		if(gibuModify > 0) {
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
