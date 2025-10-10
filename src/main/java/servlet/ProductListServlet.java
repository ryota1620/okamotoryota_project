package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.User;

@WebServlet("/products")
public class ProductListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User login = (User) req.getSession().getAttribute("loginUser");
		if (login == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		try {
			req.setAttribute("list", new ProductDAO().findAll());
			req.getRequestDispatcher("/productList.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("error", "一覧取得でエラー: " + e.getMessage());
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
	}
}
