package J_svc;

import static db.JdbcUtil_bl.*;
import java.sql.Connection;
import dao.BoardDAO;
public class BoardDeleteProService {

	public boolean isArticleWriter(int board_num, String pass)throws Exception{
		
		boolean isArticleWriter = false;
		Connection con=getConnection("blood");
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num,pass);
		close(con);
		return isArticleWriter;
	}

	public boolean removeArticle(int board_num) {
	
		boolean isRemoveSuccess = false;
		Connection con =getConnection("blood");
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int deleteCount = boardDAO.deleteArticle(board_num);
		
		if(deleteCount >0) {
			commit(con);
			isRemoveSuccess=true;
		}else {
			rollback(con);
		}
		close(con);
		return isRemoveSuccess;
	}
}