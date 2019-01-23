package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.openMysql;
import po.broad;

public class broadDAO {
        	//ͨ���û����������ȡ��һ���ݿ���Ϣ
			public List<broad> GetBroadList() {
				openMysql om = new openMysql();
				Connection conn = om.open();
				List<broad> bList = new ArrayList<broad>();
				try {
					PreparedStatement  pre = conn.prepareStatement("select * from broad");
	
					//��ȡ���صĽ��
					ResultSet  rs = pre.executeQuery();
					while(rs.next()) {
						broad b= new broad();
						b.setId(rs.getInt(1));
						b.setBroadId(rs.getString(2));
						b.setProductName(rs.getString(3));
						b.setStart(rs.getString(4));
						b.setType(rs.getString(5));
						b.setDescribe(rs.getString(6));
						bList.add(b);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return bList;
			}
}
