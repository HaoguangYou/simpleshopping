package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//数据库连接
public class openMysql {
	private final static String URL="jdbc:mysql://localhost:3306/simple_shopping";
	//用户名
	private final static String USER="root";
	//密码
	private final static String PASSWORD="123456";
	//驱动加载
	//静态块在项目运行时候就加载完成
	static {
		//加载驱动包
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//数据库连接调试
	public static Connection open() {
		//创建一个本地连接
		Connection conn = null;
		try {
			//读取连接（驱动管理 -->获取连接-->通过地址、用户名、密码去读取数据库mysql）
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回本地连接给外部调用
		return conn;
	}
	//创建一个main方法来作为本地连接测试
	public static void main(String[] args) {
		Connection conn = open();
		//判断连接是否为空
		if(conn!=null) {
			System.out.println("数据库连接成功！！！");
		}
	}
}
