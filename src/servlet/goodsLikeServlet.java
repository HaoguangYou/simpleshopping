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
 * Servlet implementation class goodsLikeServlet
 */
@WebServlet("/goodsLikeServlet")
public class goodsLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsLikeServlet() {
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
		request.setCharacterEncoding("utf-8");
		
		//��ȡ�ı���Ĳ���
		String goodsLike = request.getParameter("goodsLike");
		
		//���ݿ����
		goodsDAO goodsdao = new goodsDAO();
		List<goods> goodsList  = goodsdao.GetGoodsListByLikeValue(goodsLike);
		
		
		//����������
        request.setAttribute("goodsList", goodsList);
        //��ת
        request.getRequestDispatcher("liebiao.jsp").forward(request, response);
	}

}
