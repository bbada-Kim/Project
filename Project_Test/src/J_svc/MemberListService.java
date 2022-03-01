package J_svc;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil_bl.*;
import dao.MemberDAO;
import J_vo.MemberBean;

public class MemberListService {

	public ArrayList<MemberBean> getMemberList() {
		
		Connection con =getConnection("blood");
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		ArrayList<MemberBean> memberList = memberDAO.selectMemberList();
		close(con);
		
		return memberList;
	}

}
