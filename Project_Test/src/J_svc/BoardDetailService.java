package J_svc;

import java.sql.Connection;
import dao.BoardDAO;
import J_vo.BoardBean;
import static db.JdbcUtil_bl.*;

public class BoardDetailService {

	public BoardBean getArticle(int board_num) throws Exception {

		BoardBean article = null;
		Connection con = null;
		try {
			con = getConnection("blood");
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(con);

			int updateCount = boardDAO.updateReadCount(board_num);
			if (updateCount > 0) {
				commit(con);
			} else {
				rollback(con);
			}

			article = boardDAO.selectArticle(board_num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return article;
	}
}
