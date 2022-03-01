package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static db.JdbcUtil_bl.*;
import javax.sql.DataSource;

import J_vo.MemberBean;

public class MemberDAO {

	public static MemberDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet  rs;
	DataSource ds;
	private MemberDAO() {
		
	}
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public String selectLoginId(MemberBean member) {
		String loginId = null;
		String sql = "select m_id from bloodMember where m_id=? and m_passwd=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getM_ID());
			pstmt.setString(2, member.getM_PW());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				loginId =rs.getString("M_ID");
			}
		}catch(Exception e) {
			System.out.println("에러:"+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return loginId;
	}
	public int insertMember(MemberBean member) {
		String sql="insert into bloodMember values(?,?,?,?,?,?,?,?,?)";
		int insertCount = 0;
		System.out.println(member.getM_NAME());
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,member.getM_ID());
			pstmt.setString(2, member.getM_PW());
			pstmt.setString(3, member.getM_NAME());
			pstmt.setInt(4, member.getM_AGE());
			pstmt.setString(5, member.getM_BLOOD());
			pstmt.setString(6, member.getM_ADDR());
			pstmt.setString(7, member.getM_PHONE());
			pstmt.setString(8, member.getM_GENDER());
			pstmt.setString(9, member.getM_EMAIL());
			insertCount = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("joinMember 에러:" +e);
		}finally {
			close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<MemberBean> selectMemberList() {
		String sql="select * from bloodMember";
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
		MemberBean mb= null;
		try {
			pstmt=con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					mb=new MemberBean();
					mb.setM_ID(rs.getString("M_ID"));
					mb.setM_PW(rs.getString("M_PASSWD"));
					mb.setM_NAME(rs.getString("M_NAME"));
					mb.setM_AGE(rs.getInt("M_AGE"));
					mb.setM_BLOOD(rs.getString("M_BLOOD"));
					mb.setM_ADDR(rs.getString("M_ADDR"));
					mb.setM_PHONE(rs.getString("M_PHONE"));
					mb.setM_GENDER(rs.getString("M_GENDER"));
					mb.setM_EMAIL(rs.getString("M_EMAIL"));
					memberList.add(mb);
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println("getDetailMember 에러 : "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}
	public MemberBean selectMember(String viewId) {
		String sql="select * from bloodMember where m_id=?";
		MemberBean mb = null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, viewId);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				mb=new MemberBean();
				mb.setM_ID(rs.getString("M_ID"));
				mb.setM_PW(rs.getString("M_PASSWD"));
				mb.setM_NAME(rs.getString("M_NAME"));
				mb.setM_AGE(rs.getInt("M_AGE"));
				mb.setM_BLOOD(rs.getString("M_BLOOD"));
				mb.setM_ADDR(rs.getString("M_ADDR"));
				mb.setM_PHONE(rs.getString("M_PHONE"));
				mb.setM_GENDER(rs.getString("M_GENDER"));
				mb.setM_EMAIL(rs.getString("M_EMAIL"));
			}
			System.out.println(mb.getM_NAME());
		}catch(Exception e) {
			System.out.println("getDetailMember 에러 : "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return mb;
	}
	public int deleteMember(String deleteId) {
		String sql="delete from bloodMember where m_id=?";
		int deleteCount = 0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, deleteId);
			deleteCount = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteMember 에러:"+e);
		}finally {
			close(pstmt);
		}
		return deleteCount;
	}
}
