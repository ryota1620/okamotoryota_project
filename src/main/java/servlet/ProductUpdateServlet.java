package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

@WebServlet("/product/update")
public class ProductUpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			Product p = new Product();
			p.setId(Integer.parseInt(req.getParameter("id")));
			p.setName(req.getParameter("name"));
			p.setPrice(Double.parseDouble(req.getParameter("price")));
			p.setStock(Integer.parseInt(req.getParameter("stock")));
			p.setCategoryId(Integer.parseInt(req.getParameter("categoryId")));
			new ProductDAO().update(p);

			req.getSession().setAttribute("flash", "更新しました。");
			resp.sendRedirect(req.getContextPath() + "/products");
		} catch (Exception e) {
			req.setAttribute("error", "更新でエラー: " + e.getMessage());
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
	}
}
