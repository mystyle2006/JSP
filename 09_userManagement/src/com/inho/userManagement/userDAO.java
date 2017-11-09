package com.inho.userManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class userDAO {
	public static final int MEMBER_NONEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	
	private static userDAO instance = new userDAO();

	private userDAO() {

	}
	
	public static userDAO getInstance() {
		return instance;
	}
	
	public int confirmId(String id) {
		int ri = 0;
		System.out.println(id);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select id from member where id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next())
				ri = userDAO.MEMBER_EXISTENT;
			else
				ri = userDAO.MEMBER_NONEXISTENT;
		} catch (Exception e) {
			System.out.println("Error at confirmid()");
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				System.out.println("Error at confirmId()->Finally");
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public int insertMember(userDTO dto) {
		int ri = 0;
//		System.out.println(dto.getId() + "Insert");
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into member values (?,?,?,?,?,?,?)";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getAdres());
			pstmt.setString(4, dto.getCity());
			pstmt.setString(5, dto.getState());
			pstmt.setString(6, dto.getName());
			pstmt.setTimestamp(7, dto.getcDate());
			pstmt.executeUpdate();
			ri = userDAO.MEMBER_JOIN_SUCCESS;
		} catch(Exception e) {
			System.out.println("Error at insertMember()");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				System.out.println("Error at insertMember()-->Finally");
				e2.printStackTrace();
			}
		}
		return ri;
	}
	
	public int userCheck(String id, String pw) {
		int ri = 0;
		String dbPw;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select pw from member where id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				dbPw = set.getString("pw");
				if(dbPw.equals(pw)) {
					ri = userDAO.MEMBER_LOGIN_SUCCESS;
				} else {
					ri = userDAO.MEMBER_LOGIN_PW_NO_GOOD; // wrong password
				}
			} else {
				ri = userDAO.MEMBER_LOGIN_IS_NOT; // not existed
			}
		} catch (Exception e) {
			System.out.println("Error at userCheck()");
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				System.out.println("Error at userCheck() -> finally");
				e2.printStackTrace();
			}
		}
		return ri;
	}
	
	public userDTO getUser(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select * from member where id = ?";
		userDTO dto = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				dto = new userDTO();
				dto.setId(set.getString("id"));
				dto.setPw(set.getString("pw"));
				dto.setName(set.getString("name"));
				dto.setAdres(set.getString("adres"));
				dto.setCity(set.getString("city"));
				dto.setState(set.getString("state"));
				dto.setcDate(set.getTimestamp("cdate"));
			}
		} catch(Exception e) {
			System.out.println("Error at getUser()");
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public int updateMember(userDTO dto) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update member set pw=?, adres=?, city=?, state=?, name=? where id=?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getAdres());
			pstmt.setString(3, dto.getCity());
			pstmt.setString(4, dto.getState());
			pstmt.setString(5, dto.getName());
			pstmt.setString(6, dto.getId());
			ri = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error at updateMember");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				System.out.println("Error at updateMember -> finally");
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	private Connection getConnection() {
		Context context = null;
		DataSource dataSource = null;
		Connection con = null;
		
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			con = dataSource.getConnection();
		} catch (Exception e) {
			System.out.println("Error at getConnection()");
		}
		return con;
	}
}
