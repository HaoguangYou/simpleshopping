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
		//获取主页面大类的信息
		String BroadId = request.getParameter("BroadId");
		System.out.println("大类ID：BroadId"+BroadId);
		
		//通过大类的id读取商品的信息 ,并传给liebiao.jsp展示出大类下，所有商品的信息
		
		goodsDAO goodsdao = new goodsDAO();
		List<goods> goodsList = goodsdao.GetGoodsList(BroadId);
		
		//存入请求中
        request.setAttribute("goodsList", goodsList);
        
        
        //跳转
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
