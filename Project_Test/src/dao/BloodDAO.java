package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.sun.xml.internal.ws.api.pipe.NextAction;

import controller.BloodController;
import vo.BloodBean;
import vo.CardBean;
import vo.ChartBean;
import vo.GibuBean;
import vo.GibuDetailBean;
import vo.RequestBean;
import vo.StockBean;

import static db.JdbcUtil_bl.*;


public class BloodDAO {

	Connection con;
	private static BloodDAO bloodDAO;
	
	private BloodDAO() {
		
	}
	
	public void setConnection(Connection con) {
		this.con = con;
		
	}	
	

	public static BloodDAO getInstance() {
		if(bloodDAO == null) {
			bloodDAO = new BloodDAO();
		}
		return bloodDAO;
	}
//-------------------------------- 재고수량 조회 --------------------------------
	public BloodBean selectBloodCount() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BloodBean bloodBean = null;
		
		try {	

			pstmt=con.prepareStatement("select * from\r\n" + 
					"(select count(*) jpa from bloodstock where bc_btype='전혈' and bc_RH='PLUS' and bc_blood='A')as a,\r\n" + 
					"(select count(*) jpb from bloodstock where bc_btype='전혈' and bc_RH='PLUS' and bc_blood='B') as b,\r\n" + 
					"(select count(*) jpab from bloodstock where bc_btype='전혈' and bc_RH='PLUS' and bc_blood='AB') as c,\r\n" + 
					"(select count(*) jpo from bloodstock where bc_btype='전혈' and bc_RH='PLUS' and bc_blood='O') as d,\r\n" + 
					"(select count(*) jma from bloodstock where bc_btype='전혈' and bc_RH='MINUS' and bc_blood='A') as e, \r\n" + 
					"(select count(*) jmb from bloodstock where bc_btype='전혈' and bc_RH='MINUS' and bc_blood='B') as f,\r\n" + 
					"(select count(*) jmab from bloodstock where bc_btype='전혈' and bc_RH='MINUS' and bc_blood='AB') as g,\r\n" + 
					"(select count(*) jmo from bloodstock where bc_btype='전혈' and bc_RH='MINUS' and bc_blood='O') as h,\r\n" + 
					"(select count(*) hpa from bloodstock where bc_btype='혈장' and bc_RH='PLUS' and bc_blood='A') as i,\r\n" + 
					"(select count(*) hpb from bloodstock where bc_btype='혈장' and bc_RH='PLUS' and bc_blood='B') as j,\r\n" + 
					"(select count(*) hpab from bloodstock where bc_btype='혈장' and bc_RH='PLUS' and bc_blood='AB') as k,\r\n" + 
					"(select count(*) hpo from bloodstock where bc_btype='혈장' and bc_RH='PLUS' and bc_blood='O') as l,\r\n" + 
					"(select count(*) hma from bloodstock where bc_btype='혈장' and bc_RH='MINUS' and bc_blood='A') as m,\r\n" + 
					"(select count(*) hmb from bloodstock where bc_btype='혈장' and bc_RH='MINUS' and bc_blood='B') as n,\r\n" + 
					"(select count(*) hmab from bloodstock where bc_btype='혈장' and bc_RH='MINUS' and bc_blood='AB') as o,\r\n" + 
					"(select count(*) hmo from bloodstock where bc_btype='혈장' and bc_RH='MINUS' and bc_blood='O') as p");
			rs=pstmt.executeQuery();	
			if(rs.next()) {
				bloodBean = new BloodBean();
				bloodBean.setBc1(rs.getInt("jpa"));
				bloodBean.setBc2(rs.getInt("jpb"));
				bloodBean.setBc3(rs.getInt("jpab"));
				bloodBean.setBc4(rs.getInt("jpo"));
				bloodBean.setBc5(rs.getInt("jma"));
				bloodBean.setBc6(rs.getInt("jmb"));
				bloodBean.setBc7(rs.getInt("jmab"));
				bloodBean.setBc8(rs.getInt("jmo"));
				bloodBean.setBc9(rs.getInt("hpa"));
				bloodBean.setBc10(rs.getInt("hpb"));
				bloodBean.setBc11(rs.getInt("hpab"));
				bloodBean.setBc12(rs.getInt("hpo"));
				bloodBean.setBc13(rs.getInt("hma"));
				bloodBean.setBc14(rs.getInt("hmb"));
				bloodBean.setBc15(rs.getInt("hmab"));
				bloodBean.setBc16(rs.getInt("hmo"));
			}

			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getBloodCount 에러 : " + e);
		}
				
		return bloodBean;
	}


	
//-------------------------------- 통계리스트 차트 조회 --------------------------------	
	public ChartBean chartBloodCount() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ChartBean chartBean = null;
		
		try {
			pstmt = con.prepareStatement("select * from\r\n" + 
					"(select count(*) all_blood from bloodstock where bc_status='입고') as a,\r\n" + 
					"(select count(*) gi_blood from bloodstock where re_idx is null and bc_status='입고') as b,\r\n" + 
					"(select count(*) re_blood from bloodstock where re_idx is not null and bc_status='입고') as c,\r\n" + 
					"(select count(*) gi_a_blood from bloodstock where bc_blood='A' and re_idx is null and bc_status='입고') as d,\r\n" + 
					"(select count(*) gi_b_blood from bloodstock where bc_blood='B' and re_idx is null and bc_status='입고') as e,\r\n" + 
					"(select count(*) gi_o_blood from bloodstock where bc_blood='O' and re_idx is null and bc_status='입고') as f,\r\n" + 
					"(select count(*) gi_ab_blood from bloodstock where bc_blood='AB' and re_idx is null and bc_status='입고') as g,\r\n" + 
					"(select count(*) re_a_blood from bloodstock where bc_blood='A' and re_idx is not null and bc_status='입고') as h,\r\n" + 
					"(select count(*) re_b_blood from bloodstock where bc_blood='B' and re_idx is not null and bc_status='입고') as i,\r\n" + 
					"(select count(*) re_o_blood from bloodstock where bc_blood='O' and re_idx is not null and bc_status='입고') as j,\r\n" + 
					"(select count(*) re_ab_blood from bloodstock where bc_blood='AB' and re_idx is not null and bc_status='입고') as k");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				chartBean = new ChartBean();
				chartBean.setAll_blood(rs.getInt("all_blood"));
				chartBean.setGi_blood(rs.getInt("gi_blood"));
				chartBean.setRe_blood(rs.getInt("re_blood"));
				chartBean.setGi_a_blood(rs.getInt("gi_a_blood"));
				chartBean.setGi_b_blood(rs.getInt("gi_b_blood"));
				chartBean.setGi_o_blood(rs.getInt("gi_o_blood"));
				chartBean.setGi_ab_blood(rs.getInt("gi_ab_blood"));
				chartBean.setRe_a_blood(rs.getInt("re_a_blood"));
				chartBean.setRe_b_blood(rs.getInt("re_b_blood"));
				chartBean.setRe_o_blood(rs.getInt("re_o_blood"));
				chartBean.setRe_ab_blood(rs.getInt("re_ab_blood"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("chartBloodCount 에러 : "+e);
		}
		return chartBean;
	}

	
//-------------------------------- 기부신청 테이블에 값 저장하는 부분 --------------------------------	
	public int insertGibu(GibuBean gibuBean) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int insertCount = 0;
		int num=0;
		String sql = "";
		try {
			
			pstmt=con.prepareStatement("select max(do_idx) from blooddonate");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				num=rs.getInt(1)+1;
			else
				num=1;
			
			sql="insert into blooddonate(do_idx, id, do_coment, do_date, do_status) values(?,?,?,now(),?)";
					
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, gibuBean.getId());
			pstmt.setString(3, gibuBean.getDo_coment());
			pstmt.setString(4, gibuBean.getDo_status());
			
			insertCount = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("insertGibu 에러 : "+e);
		}
		return insertCount;
	}

	
//-------------------------------- 재고 테이블에 값 저장하는 부분 --------------------------------
	public int insertStock(StockBean stockBean) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int insertStock = 0;
		int num=0;
		String sql="";
		
		try {
			
			pstmt=con.prepareStatement("select max(do_idx) from blooddonate");
			rs = pstmt.executeQuery();
			if(rs.next())
			num = rs.getInt(1);
			
			sql = "insert into bloodcount (do_idx,bc_btype,bc_blood,bc_RH,bc_status) values(?,?,?,?,?);";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, stockBean.getBc_btype());
			pstmt.setString(3, stockBean.getBc_blood());
			pstmt.setString(4, stockBean.getBc_RH());
			pstmt.setString(5, stockBean.getBc_status());
			
			insertStock = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("insertStock 에러"+e);
			e.printStackTrace();
		}
		return insertStock;
	}
	

//-------------------------------- 증서 테이블에 값 저장하는 부분 --------------------------------	
	public int insertCnum(ArrayList<CardBean> list) {
		
	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int insertCnum = 0;
		int num = 0;
		int i = 0;

		String sql="";
		String updateSql = "";
		CardBean cb = new CardBean();
		try {
			pstmt = con.prepareStatement("select max(bc_idx) from bloodcount");
			rs = pstmt.executeQuery();
			if(rs.next()) 
			num = rs.getInt(1);
			
			sql = "insert into bloodcard(bc_idx,c_num,c_img) values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			while(i<list.size()) {
			
			pstmt.setInt(1, num);
			pstmt.setString(2, list.get(i).getCard());
			pstmt.setString(3, list.get(i).getOrigfilename());
			i++;
			
			insertCnum = pstmt.executeUpdate();
			}
			
//			updateSql = "update bloodcount set bc_in_date=now() where bc_idx='"+num+"'";
//			pstmt = con.prepareStatement(updateSql);
//			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("insertCnum 에러"+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return insertCnum;
	}
	
//-------------------------------- 재고테이블 목록 글의 개수 구하기 --------------------------------
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select count(*) from bloodstock");
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
	
//-------------------------------- 기부신청현황 목록 글의 개수 구하기 --------------------------------
	public int selectGibuListCount(String gid) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select count(*) from blooddonate where id='"+gid+"'");
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
//-------------------------------- 관리자 페이지에서 재고 목록 보기 --------------------------------	
	public ArrayList<StockBean> selectgibuList(int page, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String gibu_list_sql = "select * from bloodstock order by c_idx asc limit ?,10";
		ArrayList<StockBean> gibuList = new ArrayList<StockBean>();
		StockBean stock = null;
		int startrow = (page-1)*10; //읽기 시작할 row 번호
		
		try {
			pstmt = con.prepareStatement(gibu_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				stock = new StockBean();
				stock.setC_idx(rs.getInt("c_idx"));
				stock.setC_num(rs.getString("c_num"));
				stock.setC_img(rs.getString("c_img"));
				stock.setBc_btype(rs.getString("bc_btype"));
				stock.setBc_blood(rs.getString("bc_blood"));
				stock.setBc_RH(rs.getString("bc_RH"));
				stock.setBc_status(rs.getString("bc_status"));
				gibuList.add(stock);
			}
	
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getGibuList 에러 : "+e);
		}
		return gibuList;
	}

	
//-------------------------------- 기부테이블 목록 글의 개수 구하기 --------------------------------
	public int selectDoListCount() {
		int doListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select count(*) from blooddonate where do_status != '삭제'");
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				doListCount=rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("getdoListCount 에러 : "+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return doListCount;
	}	

//-------------------------------- 관리자 페이지에서 기부신청 목록 보기 --------------------------------		
	public ArrayList<GibuBean> selectDoList(int page, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GibuBean> doList = new ArrayList<GibuBean>();
		GibuBean gibuBean = null;
		int startrow = (page-1)*10; //읽기 시작할 row 번호
		
		try {
			pstmt = con.prepareStatement("select * from blooddonate where do_status != '삭제' order by do_idx asc limit ?,10");
//			pstmt = con.prepareStatement("select * from blooddonate order by do_idx asc limit ?,10");
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				gibuBean = new GibuBean();
				gibuBean.setDo_idx(rs.getInt("do_idx"));
				gibuBean.setId(rs.getString("id"));
				gibuBean.setDo_coment(rs.getString("do_coment"));
				gibuBean.setDo_date(rs.getDate("do_date"));
				gibuBean.setDo_status(rs.getString("do_status"));
				doList.add(gibuBean);
			}
			
		}catch(Exception e) {
			System.out.println("selectDoList 에러 : "+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return doList;
	}

	
//-------------------------------- 기부신청 목록 페이지에서 증서,기부증 상세보기 --------------------------------		
	public ArrayList<StockBean> selectGiList(int page, int limit, int do_idx) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StockBean> giList = new ArrayList<StockBean>();
		StockBean stock = null;
		int startrow = (page-1)*10; //읽기 시작할 row 번호
		
		try {
			pstmt = con.prepareStatement("select * from bloodstock where do_idx='"+do_idx+"' and bc_status='신청중' order by c_idx asc limit ?,10");
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				stock = new StockBean();
				stock.setC_idx(rs.getInt("c_idx"));
				stock.setC_num(rs.getString("c_num"));
				stock.setC_img(rs.getString("c_img"));
				giList.add(stock);
			}

		}catch(Exception e) {
			System.out.println("selectGiList 에러 : "+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return giList;
	}	
	
	
//-------------------------------- 기부신청 목록 페이지에서 혈액정보 상세보기 --------------------------------		
	public GibuDetailBean selectGiStock(int do_idx) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GibuDetailBean gdb = null;
		
		try {
			pstmt = con.prepareStatement("select * from bloodstock where do_idx='"+do_idx+"' limit 1");
			rs = pstmt.executeQuery();
				
			if(rs.next()) {
				gdb = new GibuDetailBean();
				gdb.setBc_btype(rs.getString("bc_btype"));
				gdb.setBc_RH(rs.getString("bc_blood"));
				gdb.setBc_blood(rs.getString("bc_RH"));
			}
		}catch(Exception e) {
			System.out.println("selectGoStock 에러 : "+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return gdb;
	}
	
	
	//-------------------------------- 회원 페이지에서 기부신청 목록 보기 --------------------------------		
//		public GibuBean selectGibuList(String gid) {
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			GibuBean gibuBean = null;
//			
//			try {
//				
//				pstmt = con.prepareStatement("select * from\r\n" +
//						"(select do_idx from blooddonate where id='"+gid+"') as a,\r\n"+
//						"(select id from blooddonate where id='"+gid+"') as b,\r\n" + 
//						"(select do_coment from blooddonate where id='"+gid+"') as c,\r\n" + 
//						"(select do_date from blooddonate where id='"+gid+"') as d,\r\n" + 
//						"(select do_status from blooddonate where id='"+gid+"') as e;");
//				rs=pstmt.executeQuery();
//					
//				if(rs.next()) {
//					
//					gibuBean = new GibuBean();
//					gibuBean.setDo_idx(rs.getInt("do_idx"));
//					gibuBean.setId(rs.getString("id"));
//					gibuBean.setDo_coment(rs.getString("do_coment"));
//					gibuBean.setDo_date(rs.getDate("do_date"));
//					gibuBean.setDo_status(rs.getString("do_status"));
//			
//				}
//			}catch(Exception e) {
//				System.out.println("selectGibuList 에러 : "+e);
//				e.printStackTrace();
//			}
//			
//			return gibuBean;
//		}

		
	//-------------------------------- 회원 페이지에서 기부 신청 현황 목록 보기 --------------------------------		
		public ArrayList<GibuBean> selectGibuList(int page, int limit, String gid) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<GibuBean> gibuList = new ArrayList<GibuBean>();
			GibuBean gibuBean = null;
			int startrow = (page-1)*10; //읽기 시작할 row 번호
			int num=0;
				try {
					
					pstmt = con.prepareStatement("select * from blooddonate where id='"+gid+"' and do_status != '삭제' order by do_idx asc limit ?,10");

					pstmt.setInt(1, startrow);
					rs=pstmt.executeQuery();
					
					while(rs.next()) {
						gibuBean = new GibuBean();
						gibuBean.setDo_idx(rs.getInt("do_idx"));
						gibuBean.setId(rs.getString("id"));
						gibuBean.setDo_coment(rs.getString("do_coment"));
						gibuBean.setDo_date(rs.getDate("do_date"));
						gibuBean.setDo_status(rs.getString("do_status"));
						gibuList.add(gibuBean);
					}
				}catch(Exception e) {
					System.out.println("selectCardList 에러 : "+e);
					e.printStackTrace();
				}
			return gibuList;
		}	

		
//-------------------------------- 회원 페이지에서 기부 신청 상태 수정 --------------------------------			
		public int gibuStatusMod(GibuBean gibuMod) {
			PreparedStatement pstmt = null;
			
			int statusMod = 0;
				try {
					pstmt = con.prepareStatement("update blooddonate set do_status=? where do_idx=?");
					pstmt.setString(1, gibuMod.getDo_status());
					pstmt.setInt(2, gibuMod.getDo_idx());
					statusMod = pstmt.executeUpdate();
				}catch(Exception e) {
					System.out.println("gibuStatusMod 에러 : "+e);
					e.printStackTrace();
				}finally {
					close(pstmt);
				}
			return statusMod;
		}	
//-------------------------------- 관리자 페이지에서 기부신청 상세 보기 --------------------------------
	public GibuBean selectArticle(int do_idx) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GibuBean gibuBean = null;
		
		try {
			pstmt = con.prepareStatement("select * from gibu_write where do_idx=?");
			pstmt.setInt(1, do_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				gibuBean = new GibuBean();
				gibuBean.setDo_idx(rs.getInt("do_idx"));
				gibuBean.setId(rs.getString("do_id"));
				gibuBean.setDo_coment(rs.getString("do_coment"));
//				gibuBean.setDo_date(rs.getString("do_date"));
				gibuBean.setDo_status(rs.getString("do_status"));
			
			}
		}catch(Exception e) {
			System.out.println("getDetail gibu 에러 : "+e);
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return gibuBean;
	}


//-------------------------------- 관리자 페이지에서 재고 상세 보기 --------------------------------	
	public StockBean selectStockBean(int bc_idx) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StockBean stock = null;
		
		try {
			pstmt=con.prepareStatement("select * from list where bc_idx=?");
			pstmt.setInt(1, bc_idx);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				stock = new StockBean();
//				stock.setBc_idx(rs.getInt("bc_idx"));
//				stock.setBc_cnum(rs.getString("c_num"));
//				stock.setBc_image(rs.getString("c_img"));
				stock.setBc_btype(rs.getString("bc_btype"));
				stock.setBc_blood(rs.getString("bc_blood"));
				stock.setBc_RH(rs.getString("bc_RH"));
				stock.setBc_status(rs.getString("bc_status"));
			}
		}catch(Exception e) {
			System.out.println("getDetail stock 에러 : "+e);
			e.printStackTrace();
		}
		return stock;
	}


//-------------------------------- 관리자 페이지에서 재고 상세 보기 --------------------------------	
//	public CnumBean selectCnumBean(int c_idx) {
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		CnumBean cnum = null;
//		
//		try {
//			pstmt = con.prepareStatement("select * from cnum where c_idx=?");
//			pstmt.setInt(1, c_idx);
//			rs=pstmt.executeQuery();
//			
//			if(rs.next()) {
//				cnum = new CnumBean();
//				cnum.setC_idx(rs.getInt("c_idx"));
//				cnum.setC_num1(rs.getString("c_num1"));
//				cnum.setC_num2(rs.getString("c_num2"));
//				cnum.setC_num3(rs.getString("c_num3"));
//				cnum.setC_num4(rs.getString("c_num4"));
//				cnum.setC_num5(rs.getString("c_num5"));
//				cnum.setC_num6(rs.getString("c_num6"));
//				cnum.setC_num7(rs.getString("c_num7"));
//				cnum.setC_num8(rs.getString("c_num8"));
//				cnum.setC_num9(rs.getString("c_num9"));
//				cnum.setC_num10(rs.getString("c_num10"));
//			}
//		}catch(Exception e) {
//			System.out.println("selectCnumBean 에러" +e);
//			e.printStackTrace();
//		}finally {
//			close(pstmt);
//		}
//		return cnum;
//	}
//-------------------------------- 관리자 페이지에서 기부신청 수정하는 부분 --------------------------------		
	public int updateGibuBean(GibuBean gibuBean) {

		int updateGibu = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement("update blooddonate set do_status=? where do_idx=?");
			pstmt.setString(1, gibuBean.getDo_status());
			pstmt.setInt(2, gibuBean.getDo_idx());
			updateGibu = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("gibuModify 에러"+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateGibu;
	}

	
//-------------------------------- 관리자 페이지에서 재고(stock) 수정하는 부분 --------------------------------			
	public int updateStockBean(StockBean stock) {
		
		int updateStock = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement
					("update bloodtest set bc_btype=?, bc_blood=?, bc_RH=?, bc_status=? where bc_idx=?");
			pstmt.setString(1, stock.getBc_btype());
			pstmt.setString(2, stock.getBc_blood());
			pstmt.setString(3, stock.getBc_RH());
			pstmt.setString(4, stock.getBc_status());
//			pstmt.setInt(5, stock.getBc_idx());
			updateStock = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("stockModify 에러"+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateStock;
	}

	
//-------------------------------- 삭제 페이지에서 기부신청테이블 항목 삭제 --------------------------------	
	public int deleteGibu(int do_idx) {
		
		PreparedStatement pstmt = null;
		int deleteGibu = 0;
		
		try {
			pstmt=con.prepareStatement("delete from gibu_write where do_idx=?");
			pstmt.setInt(1, do_idx);
			deleteGibu = pstmt.executeUpdate();
		
		}catch(Exception e) {
			System.out.println("gibuDelete 에러"+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteGibu;
	}

	
//-------------------------------- 삭제 페이지에서 재고 테이블 항목 삭제 --------------------------------	
	public int deleteStock(int bc_idx) {

		PreparedStatement pstmt = null;
		int deleteStock = 0;
		
		try {
			pstmt = con.prepareStatement("delete from bloodtest where bc_idx=?");
			pstmt.setInt(1, bc_idx);
			deleteStock = pstmt.executeUpdate();
		
		}catch(Exception e) {
			System.out.println("stockDelete 에러"+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteStock;
	}

//-------------------------------- 요청신청 목록 글 개수 --------------------------------	
	public int selectRbListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select count(*) from bloodrequest");
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				listCount=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getRbListCount 에러 : "+e);
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	
//-------------------------------- 요청신청 목록 --------------------------------		
	public ArrayList<RequestBean> selectRequestList(int page, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String request_list_sql = "select * from bloodrequest order by re_idx asc limit ?,10";
		ArrayList<RequestBean> rbList = new ArrayList<RequestBean>();
		RequestBean requestBean = null;
		int startrow = (page-1)*10; //읽기 시작할 row 번호
		
		try {
			pstmt = con.prepareStatement(request_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				requestBean = new RequestBean();
				requestBean.setRe_idx(rs.getInt("re_idx"));
				requestBean.setId(rs.getString("id"));
				requestBean.setRe_wri_date(rs.getDate("re_wri_date"));
				requestBean.setRe_locate(rs.getString("re_locate"));
				requestBean.setRe_content(rs.getString("re_content"));
				requestBean.setRe_image(rs.getString("re_image"));
				requestBean.setRe_date(rs.getDate("re_date"));
				requestBean.setRe_btype(rs.getString("re_btype"));
				requestBean.setRe_rh(rs.getString("re_rh"));
				requestBean.setRe_blood(rs.getString("re_blood"));
				requestBean.setRe_count(rs.getInt("re_count"));
				requestBean.setRe_status(rs.getString("re_status"));
				rbList.add(requestBean);
			}
	
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getRbList 에러 : "+e);
		}
		return rbList;
	}
	
//-------------------------------- 관리자 페이지에서 요청신청 수정  --------------------------------		
//	public int updateReBean(RequestBean reBean) {
//
//		int updateRe = 0;
//		PreparedStatement pstmt = null;
//		
//		try {
//			pstmt = con.prepareStatement("update re_blood set re_locate=?,re_date=?,re_status=? where re_id=?");
//			pstmt.setString(1, reBean.getRe_locate());
//			pstmt.setString(2, reBean.getRe_date());
//			pstmt.setString(3, reBean.getRe_status());
//			pstmt.setString(4, reBean.getRe_id());
//			updateRe = pstmt.executeUpdate();
//	
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			close(pstmt);
//		}
//		return updateRe;
//	}

	
//-------------------------------- 관리자 페이지에서 요청신청에 대한 재고상태 수정 --------------------------------	
	public int updateStock(StockBean stock, int re_count) {
		
		int updateStockStat = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement("update bloodtest set bc_status=? where bc_id=? limit "+re_count);
			pstmt.setString(1, stock.getBc_status());
//			pstmt.setString(2, stock.getBc_id());
			updateStockStat = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateStockStat;
	}

	
//-------------------------------- 기부신청목록 증서 상세에서 재고 상태 변경 --------------------------------	
	public int updateInStockStatus(int c_idx) {

		int updateStockStatus = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		String sql="";
		int num = 0;
		try {
			pstmt = con.prepareStatement("select bc_idx from bloodstock where c_idx='"+c_idx+"' limit 1");
			rs=pstmt.executeQuery();
			if(rs.next())
			num = rs.getInt(1);
			
			sql = "update bloodcount set bc_status='입고', bc_in_date=now() where bc_idx=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			updateStockStatus = pstmt.executeUpdate();
			
			System.out.println(pstmt);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateStockStatus;
	}

	
//-------------------------------- 요청신청목록 증서 상세 페이지 글 개수 --------------------------------	
	public int selectRdListCount() {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int listcount=0;
		try {
		pstmt = con.prepareStatement("select count(*) from bloodstock where re_idx is null and bc_status='입고'");
		rs=pstmt.executeQuery();
		
		if(rs.next())
			listcount = rs.getInt(1);
		
		}catch(Exception e) {
			System.out.println("selectRdCount 에러 : "+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return listcount;
	}

	
//-------------------------------- 요청신청목록 증서 상세 페이지 --------------------------------	
	public ArrayList<StockBean> selectRdStockList(int page, int limit) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String request_list_sql = "select c_idx, c_num, c_img, bc_btype, bc_blood, bc_RH, bc_status "
				+ "from bloodstock where re_idx is null and bc_status='입고' order by c_idx asc limit ?,10";
		ArrayList<StockBean> rbStockList = new ArrayList<StockBean>();
		StockBean stockBean = null;
		int startrow = (page-1)*10; //읽기 시작할 row 번호
		
		try {
			pstmt = con.prepareStatement(request_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				stockBean = new StockBean();
				stockBean.setC_idx(rs.getInt("c_idx"));
				stockBean.setC_num(rs.getString("c_num"));
				stockBean.setC_img(rs.getString("c_img"));
				stockBean.setBc_btype(rs.getString("bc_btype"));
				stockBean.setBc_RH(rs.getString("bc_RH"));
				stockBean.setBc_blood(rs.getString("bc_blood"));
				stockBean.setBc_status(rs.getString("bc_status"));
				rbStockList.add(stockBean);
			}
		}catch(Exception e) {
			System.out.println("selectRdStockList 에러 : "+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return rbStockList;
	}

	
//-------------------------------- 요청신청목록 증서 할당 갯수 불러오기  --------------------------------------------		
	public RequestBean selectRequestBean(RequestBean requestBean, int re_idx) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select * from bloodrequest re_count where re_idx='"+re_idx+"'");
			rs=pstmt.executeQuery();
				if(rs.next()) {
					requestBean.setRe_count(rs.getInt("re_count"));
				}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return requestBean;
	}

	
//-------------------------------- 요청신청별 재고리스트에서 각 요청자에게 재고를 할당하는 부분  --------------------------------------------		
	public int updateRequestStock(String[] checkList, ArrayList<StockBean> stockBean, int re_idx) {

		int updateReStock = 0;

		PreparedStatement pstmt = null;

		try {
			pstmt=con.prepareStatement("update bloodcard set re_idx='"+re_idx+"',c_out_date=now() where c_num=?");
			for(int i=0; i<checkList.length; i++) {
				for(int j=0; j<stockBean.size(); j++) {
					if(stockBean.get(j).getC_num().equals(checkList[i])) {
						pstmt.setString(1, stockBean.get(j).getC_num());
						updateReStock = pstmt.executeUpdate();
					}
				}
			}
		}catch(Exception e) {
			System.out.println("updateRequestStock 에러 : "+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return updateReStock;
	}

	
//-------------------------------- 기부신청 테이블 상태 변경 --------------------------------------------		

	public int updateGibuDel(GibuBean gibuBean) {
		int updateGibuDel = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement("update blooddonate set do_status='삭제' where do_idx=?");
			pstmt.setInt(1, gibuBean.getDo_idx());
			updateGibuDel = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("gibuModify 에러"+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateGibuDel;
	}


//-------------------------------- 요청신청 테이블 상태 변경 --------------------------------------------	
	public int updateRequestBean(RequestBean requestBean) {
		int updateGibu = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement("update bloodrequest set re_status=? where re_idx=?");
			pstmt.setString(1, requestBean.getRe_status());
			pstmt.setInt(2, requestBean.getRe_idx());
			updateGibu = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("requestStatusMod 에러"+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateGibu;
	}

	
//-------------------------------- 요청별 헌혈증 할당 리스트 조회 --------------------------------------------	
	
	public ArrayList<StockBean> selectRequestGiveList(int page, int limit, int re_idx) {
		
		ArrayList<StockBean> requestGiveList = new ArrayList<StockBean>();
		StockBean stockBean = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("select * from bloodstock where re_idx='"+re_idx+"'");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stockBean = new StockBean();
				stockBean.setC_num(rs.getString("c_num"));
				stockBean.setC_img(rs.getString("c_img"));
				stockBean.setBc_btype(rs.getString("bc_btype"));
				stockBean.setBc_RH(rs.getString("bc_RH"));
				stockBean.setBc_blood(rs.getString("bc_blood"));
				requestGiveList.add(stockBean);
			}
			
			
		}catch(Exception e) {
			System.out.println("selectRequestGiveList 에러 : "+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return requestGiveList;
	}
}
