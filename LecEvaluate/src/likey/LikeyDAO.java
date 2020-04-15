package likey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class LikeyDAO {

	public int like(String userID, String evaluationID, String userIP) {
		String SQL = "insert into likey values (?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL); //준비
			pstmt.setString(1, userID);
			pstmt.setString(2, evaluationID);
			pstmt.setString(3, userIP);
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
	
}
