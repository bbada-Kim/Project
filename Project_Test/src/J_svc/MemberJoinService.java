package J_svc;

import java.sql.Connection;

import dao.MemberDAO;

import static db.JdbcUtil_bl.*;
import J_vo.MemberBean;

public class MemberJoinService {

	public boolean joinMember(MemberBean member) {
		boolean joinSuccess =false;
		MemberDAO memberDAO = MemberDAO.getInstance();
		Connection con =getConnection("blood");
		memberDAO.setConnection(con);
		int insertCount = memberDAO.insertMember(member);
		
		if(insertCount > 0 ) {
			joinSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		close(con);
		return joinSuccess;
	}
}
