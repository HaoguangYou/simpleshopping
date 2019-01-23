package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.openMysql;
import po.user;

//���ݿ����
public class userDAO {
	//���ݿ��û�����֤
	public int login(String username,String password) {
		openMysql om = new openMysql();
		Connection conn = om.open();
		try {
			PreparedStatement  pre = conn.prepareStatement("select * from user where username=? and password =?  and type!=0 and type!=-1");
			pre.setString(1, username);
			pre.setString(2, password);
			//��ȡ���صĽ��
			ResultSet  rs = pre.executeQuery();
			while(rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	//��ȡ�����û���Ϣ
		public List<user> GerUserList() {
			openMysql om = new openMysql();
			Connection conn = om.open();
			//����һ���洢��ʵ��ģ���м���
			List<user> userList = new ArrayList<user>();
			try {
				PreparedStatement  pre = conn.prepareStatement("select * from user");
		
				//��ȡ���صĽ��
				ResultSet  rs = pre.executeQuery();
				while(rs.next()) {
					//��һ��ʵ�弯��
					user u = new user();
					u.setId(rs.getInt(1));
					u.setUsername(rs.getString(2));
					u.setPassword(	rs.getString(3));
					
					//�ѵ�һʵ�崫��һ������
					userList.add(u);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userList;
		}
		
		//ע������
		public int regist(user u) {
			openMysql om = new openMysql();
			Connection conn = om.open();
			int i =0;
			try {
				PreparedStatement  pre = conn.prepareStatement("insert  user(username,password,phone,type)  VALUE(?,?,?,?)");
				pre.setString(1, u.getUsername());
				pre.setString(2, u.getPassword());
				pre.setString(3,u.getPhone());
				pre.setString(4, "1");
				//��ȡ���صĽ�� ֻҪsql��ȷ�����оͷ�����
				 i = pre.executeUpdate();
				return i;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		
		//ͨ���û����������ȡ��һ���ݿ���Ϣ
		public user GerUserListById(String username,String password) {
			openMysql om = new openMysql();
			Connection conn = om.open();
			user u = new user();
			try {
				PreparedStatement  pre = conn.prepareStatement("select * from user where username=? and password = ?");
				pre.setString(1, username);
				pre.setString(2, password);
				
				//��ȡ���صĽ�� ֻҪsql��ȷ�����оͷ�����
				ResultSet  rs = pre.executeQuery();
				while(rs.next()) {
					//��һ��ʵ�弯��
					u.setId(rs.getInt(1));
					u.setUsername(rs.getString(2));
					u.setPassword(	rs.getString(3));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return u;
		}
}
