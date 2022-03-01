package J_svc;

import J_vo.BoardBean;
import java.sql.Connection;
import dao.BoardDAO;
import static db.JdbcUtil_bl.*;

public class BoardWriteProService {

	public boolean registArticle(BoardBean boardBean)	throws Exception{
		boolean isWriteSucess = false;
		Connection con=null;
		try {
		con = getConnection("blood");
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertCount = boardDAO.insertArticle(boardBean);
		
		if(insertCount>0) {
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
