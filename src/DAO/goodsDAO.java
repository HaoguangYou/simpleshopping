package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.openMysql;
import po.broad;
import po.goods;
import po.goodsDetails;

public class goodsDAO {
	
	//通过商品大类 获取商品详情
	public List<goods> GetGoodsList(String broadId) {
		openMysql om = new openMysql();
		Connection conn = om.open();
		List<goods> GList = new ArrayList<goods>();
		try {
			PreparedStatement  pre = conn.prepareStatement("select * from goods where broadId = ?");
			pre.setString(1, broadId);
			//获取返回的结果
			ResultSet  rs = pre.executeQuery();
			while(rs.next()) {
				goods g= new goods();
				g.setGid(rs.getString(2));
				g.setBroadId(rs.getString(4));
				g.setGoodsName(rs.getString(3));
				g.setStart(rs.getString(5));
				g.setManufacturer(rs.getString(6));
				g.setPrice(rs.getString(7));
				g.setImage(rs.getString(8));
				g.setDescribe(rs.getString(9));
				
				GList.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return GList;
	}
	
	
	
	    //通过商品gid 获取商品信息
		public List<goods> GetGoodsListByGid(String gid) {
			openMysql om = new openMysql();
			Connection conn = om.open();
			List<goods> GList = new ArrayList<goods>();
			try {
				PreparedStatement  pre = conn.prepareStatement("select * from goods g join goodsdetails gd on g.gid = gd.gid where g.start=1 and g.gid=?");
				pre.setString(1, gid);
				//获取返回的结果
				ResultSet  rs = pre.executeQuery();
				while(rs.next()) {
					goods g= new goods();
					g.setGid(rs.getString(2));
					g.setBroadId(rs.getString(4));
					g.setGoodsName(rs.getString(3));
					g.setStart(rs.getString(5));
					g.setManufacturer(rs.getString(6));
					g.setPrice(rs.getString(7));
					g.setImage(rs.getString(8));
					g.setDescribe(rs.getString(9));
					
					goodsDetails gd = new goodsDetails();
					gd.setId(rs.getInt(10));
					gd.setBarCode(rs.getString(12));
					gd.setNum(rs.getString(14));
					gd.setSpecification(rs.getString(13));
				    gd.setVersion(rs.getString(15));
				    gd.setPrice(rs.getString(7));
					gd.setColor(rs.getString(16));
					gd.setCreationTime(rs.getString(17));
				    gd.setDescribe(rs.getString(18));
				    gd.setImg(rs.getString(19));
					
					g.setGoodsdetails(gd);
					GList.add(g);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return GList;
		}
		
		
		public List<goods> GetGoodsListByLikeValue(String goodsLike) {
			openMysql om = new openMysql();
			Connection conn = om.open();
			List<goods> GList = new ArrayList<goods>();
			try {
				PreparedStatement  pre = conn.prepareStatement("select * from goods where  goodsName like ?");
				pre.setString(1, "%"+goodsLike+"%");
				//获取返回的结果
				ResultSet  rs = pre.executeQuery();
				while(rs.next()) {
					goods g= new goods();
					g.setGid(rs.getString(2));
					g.setBroadId(rs.getString(4));
					g.setGoodsName(rs.getString(3));
					g.setStart(rs.getString(5));
					g.setManufacturer(rs.getString(6));
					g.setPrice(rs.getString(7));
					g.setImage(rs.getString(8));
					g.setDescribe(rs.getString(9));
					
					GList.add(g);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return GList;
		}
	
}
