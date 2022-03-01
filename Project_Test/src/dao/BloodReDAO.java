package dao;

import static db.JdbcUtil_bl.*;
import java.sql.*;
import java.util.ArrayList;

import J_vo.BloodReBean;
import J_vo.UpdateBean;

public class BloodReDAO {

	Connection con;
	private static BloodReDAO boardDAO;
	
	private BloodReDAO() {
		
	}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public static BloodReDAO getInstance(){
		
		if(boardDAO ==null){
			boardDAO = new BloodReDAO();
		}
		
		return boardDAO;
	}
		
//요청신청 회원 insert 
	public int insertArticle(BloodReBean bloodReBean) {
		
		PreparedStatement pstmt = null;
		String sql = "";
		int insertCount = 0;
		try {
			sql = "insert into bloodrequest values(null,?,?,?,?,?,?,?,?,?,now(),?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bloodReBean.getID());
			pstmt.setString(2, bloodReBean.getRe_locate());
			pstmt.setString(3, bloodReBean.getRe_content());
			pstmt.setString(4, bloodReBean.getRe_date());
			pstmt.setInt(5, bloodReBean.getRe_count());
			pstmt.setString(6, bloodReBean.getRe_btype());
			pstmt.setString(7, bloodReBean.getRe_blood());
			pstmt.setString(8, bloodReBean.getRe_rh());
			pstmt.setString(9, bloodReBean.getRe_status());
			pstmt.setString(10, bloodReBean.getRe_image());
			insertCount = pstmt.executeUpdate();
			System.out.println(pstmt);
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("boardModify 에러 : " + ex);
		}finally{
			close(pstmt);
		}

		return insertCount;

	}

	public BloodReBean selectRequestList(String gid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BloodReBean bloodReBean = null;
	
		try {
			
			pstmt = con.prepareStatement("select * from\r\n" + 
					"(select id from bloodrequest where id='"+gid+"') as a,\r\n" + 
					"(select re_locate from bloodrequest where id='"+gid+"') as b,\r\n" + 
					"(select re_content from bloodrequest where id='"+gid+"') as c,\r\n" + 
					"(select re_date from bloodrequest where id='"+gid+"') as d,\r\n" + 
					"(select re_count from bloodrequest where id='"+gid+"') as e,\r\n" + 
					"(select re_btype from bloodrequest where id='"+gid+"') as f,\r\n" + 
					"(select re_blood from bloodrequest where id='"+gid+"') as g,\r\n" + 
					"(select re_rh from bloodrequest where id='"+gid+"') as h,\r\n" + 
					"(select re_wri_date from bloodrequest where id='"+gid+"') as i,\r\n" + 
					"(select re_status from bloodrequest where id='"+gid+"') as j,\r\n" + 
					"(select re_image from bloodrequest where id='"+gid+"') as k;");
			rs=pstmt.executeQuery();
			System.out.println(pstmt);
			if(rs.next()) {
				bloodReBean = new BloodReBean();
				bloodReBean.setID(rs.getString("id"));
				bloodReBean.setRe_locate(rs.getString("RE_LOCATE"));
				bloodReBean.setRe_content(rs.getString("re_CONTENT"));
				bloodReBean.setRe_date(rs.getString("RE_DATE"));
				bloodReBean.setRe_count(rs.getInt("RE_COUNT"));
				bloodReBean.setRe_btype(rs.getString("RE_BTYPE"));
				bloodReBean.setRe_blood(rs.getString("RE_BLOOD"));
				bloodReBean.setRe_rh(rs.getString("RE_RH"));
				bloodReBean.setRe_status(rs.getString("RE_STATUS"));
				bloodReBean.setRe_wri_date(rs.getDate("RE_WRI_DATE"));
				bloodReBean.setRe_image(rs.getString("RE_IMAGE"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return bloodReBean;
	}
//페이지
	public int selectGibuListCount(String gid) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select count(*) from bloodrequest where id='"+gid+"'");
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				listCount=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getListCount 에러 : "+e);
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	public ArrayList<BloodReBean> selectGibuList(int page, int limit, String gid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BloodReBean> bloodReList = new ArrayList<BloodReBean>();
		BloodReBean bloodReBean = null;
		int startrow = (page-1)*10; //읽기 시작할 row 번호
		int num=0;
			try {
				
				pstmt = con.prepareStatement("select * from bloodrequest where id='"+gid+"' order by re_idx asc limit ?,10");

				pstmt.setInt(1, startrow);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					bloodReBean = new BloodReBean();
					bloodReBean.setID(rs.getString("id"));
					bloodReBean.setRe_locate(rs.getString("re_locate"));
					bloodReBean.setRe_content(rs.getString("re_content"));
					bloodReBean.setRe_date(rs.getString("re_date"));
					bloodReBean.setRe_count(rs.getInt("re_count"));
					bloodReBean.setRe_btype(rs.getString("re_btype"));
					bloodReBean.setRe_rh(rs.getString("re_rh"));
					bloodReBean.setRe_blood(rs.getString("re_blood"));
					bloodReBean.setRe_status(rs.getString("re_status"));
					bloodReBean.setRe_wri_date(rs.getDate("re_wri_date"));
					bloodReBean.setRe_image(rs.getString("re_image"));
					bloodReList.add(bloodReBean);
				}
				System.out.println(pstmt);
			}catch(Exception e) {
				System.out.println("selectCardList 에러 : "+e);
				e.printStackTrace();
			}
		return bloodReList;
	}	

//	public int updateArticle(UpdateBean updateBean) {
//		int updateCount = 0;
//		PreparedStatement pstmt = null;
//		String sql="update bloodtest set bc_status='승인대기', bc_id='요청신청자id' where bc_id='bin' "
//				+ "and bc_btype='전혈' and bc_rh='PLUS' and bc_blood='A' limit 2;";
//
//		try{
//			pstmt = con.prepareStatement(sql);
//			updateCount = pstmt.executeUpdate();
//		}catch(Exception ex){
//			ex.printStackTrace();
//			System.out.println("boardModify 에러 : " + ex);
//		}finally{
//			close(pstmt);
//		}
//
//		return updateCount;
//	}	

}