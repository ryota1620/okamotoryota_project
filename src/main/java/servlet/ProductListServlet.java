package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

@WebServlet("/products")
public class ProductListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ProductDAO dao = new ProductDAO();
			List<Product> products = dao.findAll();
			request.setAttribute("products", products);
			RequestDispatcher rd = request.getRequestDispatcher("productList.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
