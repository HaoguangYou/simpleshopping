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
 * Servlet implementation class xiangqingServlet
 */
@WebServlet("/xiangqingServlet")
public class xiangqingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xiangqingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取商品的id
		String gid = request.getParameter("gid");
		
		//查询商品所用信息
		goodsDAO goodsdao = new goodsDAO();
		List<goods> goodsList = goodsdao.GetGoodsListByGid(gid);
		
		//存入请求
		request.setAttribute("goodsList", goodsList);
		
		//跳转
		request.getRequestDispatcher("xiangqing.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
