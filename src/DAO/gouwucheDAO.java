package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DB.openMysql;
import po.gouwuche;

public class gouwucheDAO {
	//添加购物车
		public int setGouwuche(gouwuche g) {
			openMysql om = new openMysql();
			Connection conn = om.open();
			try {
				PreparedStatement  pre = conn.prepareStatement("INSERT shoppingCart(gdid,uid,num,start,cd) value(?,?,?,?,?)");
				pre.setString(1,g.getGdid());
				pre.setString(2,g.getUid());
				pre.setString(3,g.getNum());
				pre.setString(4, g.getStart());
				pre.setString(5, g.getCondition());				
				//获取返回的结果 
			  int i = pre.executeUpdate();
			  if(i>0) {
				  return i;
			  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		
		
		public int GetGouwucheByUid(String uid) {
			openMysql om = new openMysql();
			Connection conn = om.open();
			try {
				PreparedStatement  pre = conn.prepareStatement("select * from shoppingcart s join user u on u.id = s.uid join goodsdetails gd on gd.id = s.gdid join goods g on g.gid = gd.gid where u.id=?");
			    pre.setString(1,uid);
				//获取返回的结果
			    ResultSet rs =  pre.executeQuery();
			   while(rs.next()) {
				   //存到实体类 --
			   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
}
