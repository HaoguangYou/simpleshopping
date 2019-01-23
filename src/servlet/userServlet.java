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
		//设置中文乱码
		request.setCharacterEncoding("utf-8");
		//获取jsp页面 用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+password);
		
		//读取数据库信息判断
		userDAO userdao = new userDAO();
		int num = userdao.login(username, password);
		if(num==1) {
			System.out.println("登陆成功");
			
			//读取数据库用户信息
			user u = userdao.GerUserListById(username,password);
			
			//存入session会话
			request.getSession().setAttribute("user", u);
			
			
			//获取所有大类数据传给主页面展示
			broadDAO bd = new broadDAO();
			 List<broad> bList = 	bd.GetBroadList();
			 //传输
			 request.setAttribute("bList",bList);
			
			//跳转
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			System.out.println("登陆失败");
			
			//给jsp页面设置属性
			request.setAttribute("error", "用户名或密码错误！！！");
			
			//跳转
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
