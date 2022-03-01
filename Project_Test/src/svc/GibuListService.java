package svc;

import static db.JdbcUtil_bl.*;
import java.sql.Connection;
import java.util.ArrayList;

import vo.StockBean;
import dao.BloodDAO;
import vo.GibuBean;

public class GibuListService {

	
//------------------------- 목록 페이지 부분 -------------------------	
		public int getGibuListCount(String gid) {
			int listCount = 0;
			Connection con = null;
			try {
				con = getConnection("blood");
				BloodDAO bloodDAO = BloodDAO.getInstance();
				bloodDAO.setConnection(con);
				listCount = bloodDAO.selectGibuListCount(gid);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con);
			}
			return listCount;
		}
		

//------------------------- 기부신청 테이블 조회 부분 -------------------------	
	public ArrayList<GibuBean>  getGibuBeanList(int page, int limit,String gid) throws Exception {
		Connection con = getConnection("blood");
		ArrayList<GibuBean> gibuList = null;
		try {
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			gibuList = bloodDAO.selectGibuList(page, limit, gid);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return gibuList;
	}
}
