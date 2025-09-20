package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

@WebServlet("/productRegister")
public class ProductRegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			CategoryDAO dao = new CategoryDAO();
			List<Category> categories = dao.findAll();
			request.setAttribute("categories", categories);
			RequestDispatcher rd = request.getRequestDispatcher("productRegister.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			double price = Double.parseDouble(request.getParameter("price"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			int categoryId = Integer.parseInt(request.getParameter("category"));

			if (name == null || name.isBlank()) {
				request.setAttribute("error", "商品名を入力してください。");
				doGet(request, response);
				return;
			}
			if (price < 0 || stock < 0) {
				request.setAttribute("error", "価格または在庫数が不正です。");
				doGet(request, response);
				return;
			}

			Product product = new Product(name, price, stock, categoryId);
			ProductDAO dao = new ProductDAO();
			dao.insert(product);

			response.sendRedirect("products");
		} catch (NumberFormatException e) {
			request.setAttribute("error", "数値を正しく入力してください。");
			doGet(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
