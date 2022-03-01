package J_svc;

import dao.MemberDAO;
import static db.JdbcUtil_bl.*;
import java.sql.Connection;
public class MemberDeleteService {

	public boolean deleteMember(String deleteId) {
		
		boolean deleteResult = false;
		Connection con = getConnection("blood");
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		int deleteCount = memberDAO.deleteMember(deleteId);
		if(deleteCount > 0) {
			commit(con);
			deleteResult=true;
		}else {
			rollback(con);
		}
		close(con);
		return deleteResult;
	}

}
