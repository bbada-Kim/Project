package svc;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.BloodDAO;

import static db.JdbcUtil_bl.*;
import vo.StockBean;

public class RequestModService {

	public boolean reconfirm(HttpServletRequest request, String[] checkList, int re_idx) throws Exception{

		HttpSession session = request.getSession();
		ArrayList<StockBean> stockBean = (ArrayList<StockBean>) session.getAttribute("rdStockList");
		

		boolean isModifySuccess = false;			
		
			Connection con = getConnection("blood");
			BloodDAO bloodDAO = BloodDAO.getInstance();
			bloodDAO.setConnection(con);
			int updateRequest = bloodDAO.updateRequestStock(checkList, stockBean, re_idx);
			if(updateRequest > 0) {
				commit(con);
				isModifySuccess = true;
			}
			else {
				rollback(con);
			}
			close(con);
			
			return isModifySuccess;
	
		}
	}


