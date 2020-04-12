package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

//DB ����
public class UserDAO {
	
	public int login(String userID, String userPassword) {
		String SQL = "select userPassword from user where userID =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL); //�غ�
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery(); //��ȸ��
			
			if(rs.next()) { //������ ������ ���
				if(rs.getString(1).equals(userPassword)) {
					return 1; //�α��� ����
				}else {
					return 0; //��й�ȣ Ʋ��
				}
			}
			return -1; //���̵� ����
	
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
		}//���� �ڿ� ����
		return -2; //�����ͺ��̽� ����
	}
	
	public int join(UserDTO user) {
		String SQL = "insert into user values (?,?,?,?,false)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL); //�غ�
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserEmailHash());
			return pstmt.executeUpdate(); //insert, update, delete
			// 1: ����
			
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
		}//���� �ڿ� ����
		return -1; // ȸ������ ����
	}
	
	//������ �̸��� ��ȯ
	public String getUserEmail(String userID) {
		String SQL = "select userEmail from user where userID= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL); //�غ�
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
		}//���� �ڿ� ����
		return null; // �����ͺ��̽� ����
	}
		
	
	
	//�̸��� ���� Ȯ��
	public boolean getUserEmailChecked(String userID) {
		String SQL = "select userEmailChecked from USER where userId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL); //�غ�
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				return rs.getBoolean(1); //ù��° �Ӽ��� ��ȯ
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
		}//���� �ڿ� ����
		return false; // �����ͺ��̽� ����
	}
	
	
	
	
	//Ư�� ������� �̸��� ���� ����
	public boolean setUserEmailChecked(String userID) {
		String SQL = "update user set userEmailChecked = true where userID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL); //�غ�
			pstmt.setString(1, userID);
			pstmt.executeUpdate();
			return true; //�̹� ������ �� ���¶� �ٽ� ���� ����	
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
		}//���� �ڿ� ����
		return false; // �����ͺ��̽� ����
	}
}
