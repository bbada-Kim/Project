package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BloodDAO;


import static db.JdbcUtil_bl.*;

import vo.CardBean;
import vo.GibuBean;
import vo.StockBean;

public class GibuWriteService {

	public boolean registGibu(GibuBean gibuBean, StockBean stockBean, ArrayList<CardBean> list) {
		boolean isWriteSuccess = false;

		Connection con = null;
		try {
			con = getConnection("blood");
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			int insertCount = bloodDAO.insertGibu(gibuBean);
			int insertStock = bloodDAO.insertStock(stockBean);
			int insertCnum = bloodDAO.insertCnum(list);
			
			if(insertCount > 0 && insertStock > 0 && insertCnum > 0) {
				commit(con);
				isWriteSuccess = true;
			
			}else {
				rollback(con);
			}			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isWriteSuccess;
	}

}
