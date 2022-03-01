package J_svc;

import java.sql.Connection;
import dao.BoardDAO;
import J_vo.BoardBean;
import static db.JdbcUtil_bl.*;

public class BoardModifyFormSvc {

	public BoardBean getArticle(int board_num) {
		BoardBean article = null;
		Connection con = null;
		try {
			con = getConnection("blood");
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(con);

			article = boardDAO.selectArticle(board_num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return article;
	}
}