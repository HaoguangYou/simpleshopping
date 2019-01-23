package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.broadDAO;
import DAO.userDAO;
import po.broad;
import po.user;

/**
 * Servlet implementation class userServlet
 */
@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������������
		request.setCharacterEncoding("utf-8");
		//��ȡjspҳ�� �û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+password);
		
		//��ȡ���ݿ���Ϣ�ж�
		userDAO userdao = new userDAO();
		int num = userdao.login(username, password);
		if(num==1) {
			System.out.println("��½�ɹ�");
			
			//��ȡ���ݿ��û���Ϣ
			user u = userdao.GerUserListById(username,password);
			
			//����session�Ự
			request.getSession().setAttribute("user", u);
			
			
			//��ȡ���д������ݴ�����ҳ��չʾ
			broadDAO bd = new broadDAO();
			 List<broad> bList = 	bd.GetBroadList();
			 //����
			 request.setAttribute("bList",bList);
			
			//��ת
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			System.out.println("��½ʧ��");
			
			//��jspҳ����������
			request.setAttribute("error", "�û�����������󣡣���");
			
			//��ת
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
