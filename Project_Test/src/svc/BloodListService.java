package svc;



import static db.JdbcUtil_bl.*;
import java.sql.Connection;
import java.util.ArrayList;
import vo.BloodBean;
import dao.BloodDAO;


public class BloodListService {
	
	public BloodBean getBloodCount() throws Exception {
		Connection con = getConnection("blood");
		BloodBean bloodBean = null;
		try {
		BloodDAO bloodDAO = BloodDAO.getInstance();
		bloodDAO.setConnection(con);
		bloodBean = bloodDAO.selectBloodCount();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return bloodBean;
	}
}
