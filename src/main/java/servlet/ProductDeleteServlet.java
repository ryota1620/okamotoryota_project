package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

@WebServlet("/product/delete")
public class ProductDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String idStr = req.getParameter("id");
			if (idStr == null || idStr.isBlank()) {
				resp.sendRedirect(req.getContextPath() + "/products?error=削除対象IDが不正です。");
				return;
			}
			int id = Integer.parseInt(idStr);
			Product p = new ProductDAO().findById(id);
			if (p == null) {
				resp.sendRedirect(req.getContextPath() + "/products?error=指定の商品が見つかりません。");
				return;
			}
			req.setAttribute("product", p);
			RequestDispatcher rd = req.getRequestDispatcher("/productDeleteConfirm.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath() + "/products?error=例外が発生しました。");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			req.setCharacterEncoding("UTF-8");
			String idStr = req.getParameter("id");
			if (idStr == null || idStr.isBlank()) {
				resp.sendRedirect(req.getContextPath() + "/products?error=削除対象IDが不正です。");
				return;
			}
			int id = Integer.parseInt(idStr);
			new ProductDAO().delete(id);

			req.getSession().setAttribute("flash", "削除しました。");
			resp.sendRedirect(req.getContextPath() + "/products");
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath() + "/products?error=例外が発生しました。");
		}
	}
}
