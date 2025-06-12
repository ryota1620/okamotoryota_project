package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.entity.Category;

@WebServlet("/register")  
public class CategoryRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");

            Category category = new Category(id, name);

            CategoryDAO dao = new CategoryDAO();
            dao.insert(category);

            response.sendRedirect("category-list.jsp");

        } catch (Exception e) {
            request.setAttribute("error", "登録に失敗しました: " + e.getMessage());
            request.getRequestDispatcher("category-register.jsp").forward(request, response);
        }
    }
}
