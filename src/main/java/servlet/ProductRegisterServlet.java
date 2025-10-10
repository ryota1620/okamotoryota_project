package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

@WebServlet("/product/register")
public class ProductRegisterServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/productForm.jsp").forward(req, resp);
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String stock = req.getParameter("stock");
        String categoryId = req.getParameter("categoryId");

        if (name == null || name.isBlank()) {
            req.setAttribute("error", "商品名は必須です。");
            req.getRequestDispatcher("/productForm.jsp").forward(req, resp);
            return;
        }
        try {
            Product p = new Product();
            p.setName(name);
            p.setPrice(Double.parseDouble(price));
            p.setStock(Integer.parseInt(stock));
            p.setCategoryId(Integer.parseInt(categoryId));
            new ProductDAO().insert(p);

            req.getSession().setAttribute("flash", "登録しました。");
            resp.sendRedirect(req.getContextPath() + "/products");
        } catch (Exception e) {
            req.setAttribute("error", "登録でエラー: " + e.getMessage());
            req.getRequestDispatcher("/productForm.jsp").forward(req, resp);
        }
    }
}
