package J_svc;

import java.sql.Connection;
import static db.JdbcUtil_bl.*;
import dao.MemberDAO;
import J_vo.MemberBean;

public class MemberViewService {
	
	public MemberBean getMember (String viewId) {
		
		Connection con =getConnection("blood");
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		MemberBean member = memberDAO.selectMember(viewId);
		close(con);
		return member;
	}
}
