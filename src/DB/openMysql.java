package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//���ݿ�����
public class openMysql {
	private final static String URL="jdbc:mysql://localhost:3306/simple_shopping";
	//�û���
	private final static String USER="root";
	//����
	private final static String PASSWORD="123456";
	//��������
	//��̬������Ŀ����ʱ��ͼ������
	static {
		//����������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���ݿ����ӵ���
	public static Connection open() {
		//����һ����������
		Connection conn = null;
		try {
			//��ȡ���ӣ��������� -->��ȡ����-->ͨ����ַ���û���������ȥ��ȡ���ݿ�mysql��
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���ر������Ӹ��ⲿ����
		return conn;
	}
	//����һ��main��������Ϊ�������Ӳ���
	public static void main(String[] args) {
		Connection conn = open();
		//�ж������Ƿ�Ϊ��
		if(conn!=null) {
			System.out.println("���ݿ����ӳɹ�������");
		}
	}
}
