package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.gouwucheDAO;
import po.gouwuche;

/**
 * Servlet implementation class addGouwucheServlet
 */
@WebServlet("/addGouwucheServlet")
public class addGouwucheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addGouwucheServlet() {
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
			//��ȡҳ��ֵ
		String uid = request.getParameter("uid");
		String gdid = request.getParameter("gdid");
		
		
		gouwuche g = new gouwuche();
		g.setUid(uid);
		g.setGdid(gdid);
		g.setNum("1");
		g.setStart("1");
		g.setCondition("4");
		
		//��ӵ����ݿ�
		gouwucheDAO gd = new gouwucheDAO();
		int i = gd.setGouwuche(g);
		if(i>0) {
			System.out.println("���ﳵ��ӳɹ�");
			//��ת�����ﳵҳ��չʾ
			//��ȡ���ﳵ����Ϣ
			//�浽��������--��jsp��ʾ
			request.getRequestDispatcher("gouwuche.jsp").forward(request, response);
		}else {
			System.out.println("���ﳵ���ʧ��");
		}
		
	}

}
