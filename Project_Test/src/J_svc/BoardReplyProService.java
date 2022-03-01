package J_svc;

import java.sql.Connection;
import static db.JdbcUtil_bl.*;
import dao.BoardDAO;
import J_vo.BoardBean;

public class BoardReplyProService {

	public boolean replyArticle(BoardBean article) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection con=getConnection("blood");
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		insertCount = boardDAO.insertReplyArticle(article);
		
		if(insertCount >0) {
			commit(con);
			isReplySuccess=true;
		}else {
			rollback(con);
		}
		close(con);
		return isReplySuccess;
	}

}
