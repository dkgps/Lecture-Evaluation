package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

//DB 접근
public class UserDAO {
	
	public int login(String userID, String userPassword) {
		String SQL = "select userPassword from user where userID =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL); //준비
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery(); //조회시
			
			if(rs.next()) { //실행결과 존재할 경우
				if(rs.getString(1).equals(userPassword)) {
					return 1; //로그인 성공
				}else {
					return 0; //비밀번호 틀림
				}
			}
			return -1; //아이디 없음
	
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try{if(conn != null) {conn.close();}} catch (Exception e) {
				e.printStackTrace();
			}
			try{if(pstmt != null){pstmt.close();}} catch (Exception e) {
				e.printStackTrace();
			}
			try{if(rs != null) {rs.close();}} catch (Exception e) {
				e.printStackTrace();
			}
		}//접근 자원 해지
		return -2; //데이터베이스 오류
	}
	
	public int join(UserDTO user) {
		String SQL = "insert into user values (?,?,?,?,false)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL); //준비
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserEmailHash());
			return pstmt.executeUpdate(); //insert, update, delete
			// 1: 성공
			
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try{if(conn != null) {conn.close();}} catch (Exception e) {
				e.printStackTrace();
			}
			try{if(pstmt != null){pstmt.close();}} catch (Exception e) {
				e.printStackTrace();
			}
			try{if(rs != null) {rs.close();}} catch (Exception e) {
				e.printStackTrace();
			}
		}//접근 자원 해지
		return -1; // 회원가입 실패
	}
	
	//유저의 이메일 반환
	public String getUserEmail(String userID) {
		String SQL = "select userEmail from user where userID= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL); //준비
			pstmt.setString(1, userID);
			rs=pstmt.executeQuery();
				
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try{if(conn != null) { conn.close();}} catch (Exception e) {
				e.printStackTrace();
			}
			try{if(pstmt != null){pstmt.close();}} catch (Exception e) {
				e.printStackTrace();
			}
			try{if(rs != null) {rs.close();}} catch (Exception e) {
				e.printStackTrace();
			}
		}//접근 자원 해지
		return null; // 데이터베이스 오류
	}
		
	
	
	//이메일 인증 확인
	public boolean getUserEmailChecked(String userID) {
		String SQL = "select userEmailChecked from USER where userId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL); //준비
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				return rs.getBoolean(1); //첫번째 속성값 반환
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try{if(conn != null) { conn.close();}} catch (Exception e) {
				e.printStackTrace();
			}
			try{if(pstmt != null){pstmt.close();}} catch (Exception e) {
				e.printStackTrace();
			}
			try{if(rs != null) {rs.close();}} catch (Exception e) {
				e.printStackTrace();
			}
		}//접근 자원 해지
		return false; // 데이터베이스 오류
	}
	
	
	
	
	//특정 사용자의 이메일 인증 수행
	public boolean setUserEmailChecked(String userID) {
		String SQL = "update user set userEmailChecked = true where userID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL); //준비
			pstmt.setString(1, userID);
			pstmt.executeUpdate();
			return true; //이미 인증을 한 상태라도 다시 인증 가능	
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try{if(conn != null) { conn.close();}} catch (Exception e) {
				e.printStackTrace();
			}
			try{if(pstmt != null){pstmt.close();}} catch (Exception e) {
				e.printStackTrace();
			}
			try{if(rs != null) {rs.close();}} catch (Exception e) {
				e.printStackTrace();
			}
		}//접근 자원 해지
		return false; // 데이터베이스 오류
	}
}