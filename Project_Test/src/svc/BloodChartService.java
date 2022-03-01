package svc;

import java.sql.Connection;

import dao.BloodDAO;

import static db.JdbcUtil_bl.*;
import vo.ChartBean;

public class BloodChartService {

	public ChartBean getBloodChart() throws Exception {
		Connection con = getConnection("blood");
		ChartBean chartBean = null;
		try {
		BloodDAO bloodDAO = BloodDAO.getInstance();
		bloodDAO.setConnection(con);
		chartBean = bloodDAO.chartBloodCount();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return chartBean;
	}

}
