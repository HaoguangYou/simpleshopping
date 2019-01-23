package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.openMysql;
import po.user;

//数据库操作
public class userDAO {
	//数据库用户名验证
	public int login(String username,String password) {
		openMysql om = new openMysql();
		Connection conn = om.open();
		try {
			PreparedStatement  pre = conn.prepareStatement("select * from user where username=? and password =?  and type!=0 and type!=-1");
			pre.setString(1, username);
			pre.setString(2, password);
			//获取返回的结果
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
	
	
	//获取所有用户信息
		public List<user> GerUserList() {
			openMysql om = new openMysql();
			Connection conn = om.open();
			//创建一个存储的实体模型列集合
			List<user> userList = new ArrayList<user>();
			try {
				PreparedStatement  pre = conn.prepareStatement("select * from user");
		
				//获取返回的结果
				ResultSet  rs = pre.executeQuery();
				while(rs.next()) {
					//单一的实体集合
					user u = new user();
					u.setId(rs.getInt(1));
					u.setUsername(rs.getString(2));
					u.setPassword(	rs.getString(3));
					
					//把单一实体传给一整个列
					userList.add(u);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userList;
		}
		
		//注册数据
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
				//获取返回的结果 只要sql正确能运行就返回真
				 i = pre.executeUpdate();
				return i;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		
		//通过用户名和密码读取单一数据库信息
		public user GerUserListById(String username,String password) {
			openMysql om = new openMysql();
			Connection conn = om.open();
			user u = new user();
			try {
				PreparedStatement  pre = conn.prepareStatement("select * from user where username=? and password = ?");
				pre.setString(1, username);
				pre.setString(2, password);
				
				//获取返回的结果 只要sql正确能运行就返回真
				ResultSet  rs = pre.executeQuery();
				while(rs.next()) {
					//单一的实体集合
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
