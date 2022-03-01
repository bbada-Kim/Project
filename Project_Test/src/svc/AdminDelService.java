package svc;

import java.sql.Connection;
import dao.BloodDAO;
import static db.JdbcUtil_bl.*;

public class AdminDelService {

	public boolean removeArticle(int do_idx, int bc_idx) {
		
		boolean isRemoveSuccess = false;
		Connection con = getConnection("blood");
		BloodDAO bloodDAO = BloodDAO.getInstance();
		bloodDAO.setConnection(con);

		int deleteGibu = bloodDAO.deleteGibu(do_idx);
		int deleteStock = bloodDAO.deleteStock(bc_idx);
		
			if(deleteGibu > 0 && deleteStock > 0) {
				commit(con);
				isRemoveSuccess = true;
			}
			else {
				rollback(con);
			}

			close(con);

		return isRemoveSuccess;
	}

}
