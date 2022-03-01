package J_svc;

import java.sql.Connection;
import dao.BloodReDAO;
import static db.JdbcUtil_bl.*;
import J_vo.BloodReBean;
//import vo.UpdateBean;

public class RequestWriteProService {

	
	public boolean insertCount(BloodReBean bloodReBean) {
		boolean isWriteSucess = false;
		Connection con=null;
		try {
		con = getConnection("blood");
		BloodReDAO bloodDAO=BloodReDAO.getInstance();
		bloodDAO.setConnection(con);
		int insertCount = bloodDAO.insertArticle(bloodReBean);
//		int updateArticle = bloodDAO.updateArticle(updateBean);
		System.out.println("in"+insertCount);
//		System.out.println("up"+updateArticle);
		if(insertCount>0 ) {
				commit(con);
				isWriteSucess = true;
		}else {
			rollback(con);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isWriteSucess;
	}
	}