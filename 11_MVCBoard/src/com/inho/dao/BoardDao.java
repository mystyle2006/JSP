package com.inho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.inho.dto.BoardDto;

public class BoardDao {
	
	private final int WRITE_BAD = -1;
	private final int WRITE_GOOD = 1;
	
	private final int EDIT_BAD = -1;
	
	public BoardDao() {
	}
	
	public void delete(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = null;
		
		try {
			con = getConnection();
			query = "delete from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(id));
			
			int rn = pstmt.executeUpdate();
			
			if(rn != 1) {
				System.out.println(rn);
				throw new SQLException("Found an error at pstmt.executeUpdate() at Delete()");
			}
		} catch(Exception e) {
			System.out.println("Found an error at Delete()");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e2) {
				System.out.println("Found an error at Delete() -> finally");
				e2.printStackTrace();
			}
		}
	}
	
	public int edit(String id, String name, String title, String content) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = null;
		
		try {
			con = getConnection();
			query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, Integer.parseInt(id));

			int rn = pstmt.executeUpdate();
			
			if(rn != 1) {
				throw new SQLException("Found an error at pstmt.executeUpdate() at Edit()"); 
			}
			
		} catch(Exception e) {
			System.out.println("Found an error at edit()");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e2) {
				System.out.println("Found an error at edit() -> finally");
				e2.printStackTrace();
			}
		}
		
		return Integer.parseInt(id);
	}
	
	public int write(String name, String title, String content) {
		int id = WRITE_BAD;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		
		try {
			con = getConnection();
			query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.nextval, 0, 0)";
			pstmt = con.prepareStatement(query, new String[]{"bId"});
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
				
			int rn = pstmt.executeUpdate();
			
			//get current Key
			rs = pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				id = rs.getInt(1);
				//System.out.println(id);
			}
		} catch(Exception e) {
			System.out.println("Found an error at write()");
			e.printStackTrace();		
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e2) {
				System.out.println("Found an error at write() -> finally");
				e2.printStackTrace();
			}
		}
		
		return id;
	}
	
	public BoardDto selected(String strID) {
		BoardDto dto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		
		try {
			con = getConnection();
			query = "select * from mvc_board where bid = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, strID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int bid = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				dto = new BoardDto(bid, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
			
		} catch(Exception e) {
			System.out.println("Found an error at selected()");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e2) {
				System.out.println("Found an error at selected() -> finally");
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public ArrayList<BoardDto> list(){
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		
		try {
			con = getConnection();
			query = "select * from mvc_board order by bGroup desc, bStep asc";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				if(bid==39) System.out.println("39 where are you?");
				
				BoardDto dto = new BoardDto(bid, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			System.out.println("Found an error at list()");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e2) {
				System.out.println("Found an error at list() -> finally");
				e2.printStackTrace();
			}
		}
		return dtos;
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
