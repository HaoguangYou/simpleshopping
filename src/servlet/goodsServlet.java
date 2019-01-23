package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.goodsDAO;
import po.goods;

/**
 * Servlet implementation class goodsServlet
 */
@WebServlet("/goodsServlet")
public class goodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ��ҳ��������Ϣ
		String BroadId = request.getParameter("BroadId");
		System.out.println("����ID��BroadId"+BroadId);
		
		//ͨ�������id��ȡ��Ʒ����Ϣ ,������liebiao.jspչʾ�������£�������Ʒ����Ϣ
		
		goodsDAO goodsdao = new goodsDAO();
		List<goods> goodsList = goodsdao.GetGoodsList(BroadId);
		
		//����������
        request.setAttribute("goodsList", goodsList);
        
        
        //��ת
        request.getRequestDispatcher("liebiao.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
