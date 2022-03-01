package svc;

import static db.JdbcUtil_bl.close;
import static db.JdbcUtil_bl.commit;
import static db.JdbcUtil_bl.getConnection;
import static db.JdbcUtil_bl.rollback;

import java.sql.Connection;

import dao.BloodDAO;
import vo.RequestBean;

public class AdminRequestStatusModService {

	public boolean isRequestStatusUpdate(RequestBean requestBean) {
		boolean isModifySuccess = false;
		Connection con = getConnection("blood");
		BloodDAO bloodDAO = BloodDAO.getInstance();
		bloodDAO.setConnection(con);
		
		int updateGibu = bloodDAO.updateRequestBean(requestBean);
		
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
