package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.userDAO;
import po.user;

/**
 * Servlet implementation class registServlet
 */
@WebServlet("/registServlet")
public class registServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registServlet() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		//获取注册页面信息
		
		//设置utf-8
		request.setCharacterEncoding("utf-8");
		//获取页面的信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		
		// 首先暂时放到实体类里面来 
		user u = new user();
		u.setPassword(password);
		u.setUsername(username);
		u.setPhone(phone);
		
		//存入数据库
		userDAO userdao = new userDAO();
	    int i = 	userdao.regist(u);
		if(i>0) {
			//跳转到登陆页面
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
