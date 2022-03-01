package J_svc;

import java.sql.Connection;
import static db.JdbcUtil_bl.*;
import dao.MemberDAO;
import J_vo.MemberBean;

public class MemberLoginService {
	
	public boolean login(MemberBean member) {
		Connection con = getConnection("blood");
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		boolean loginResult = false;
		String loginId = memberDAO.selectLoginId(member);
		if(loginId != null) {
			loginResult = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return loginResult;
	}
}
