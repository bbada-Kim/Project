package J_svc;

import java.sql.Connection;
import java.util.ArrayList;
import dao.BloodReDAO;
import static db.JdbcUtil_bl.*;
import J_vo.BloodReBean;

public class RequestListService {

	public ArrayList<BloodReBean>  getRequestList(int page, int limit,String gid) throws Exception {
		Connection con = getConnection("blood");
		ArrayList<BloodReBean> bloodList = null;
		try {
			BloodReDAO bloodReDAO = BloodReDAO.getInstance();
			bloodReDAO.setConnection(con);
			bloodList = bloodReDAO.selectGibuList(page, limit, gid);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return bloodList;
	}

	public int getGibuListCount(String gid) {
		int listCount = 0;
		Connection con = null;
		try {
			con = getConnection("blood");
			BloodReDAO bloodReDAO = BloodReDAO.getInstance();
			bloodReDAO.setConnection(con);
			listCount = bloodReDAO.selectGibuListCount(gid);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return listCount;
	}

}
