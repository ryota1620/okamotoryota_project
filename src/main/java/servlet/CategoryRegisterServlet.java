package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.entity.Category;

@WebServlet("/register")  // ★ web.xml不要、URLマッピングを定義
public class CategoryRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            // フォームからの入力取得
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");

            // 入力値を元にCategoryオブジェクトを生成
            Category category = new Category(id, name);

            // DAOでDBに保存
            CategoryDAO dao = new CategoryDAO();
            dao.insert(category);

            // 成功したら一覧表示にリダイレクト
            response.sendRedirect("category-list.jsp");

        } catch (Exception e) {
            // エラー時はフォーム画面へ戻し、メッセージ表示
            request.setAttribute("error", "登録に失敗しました: " + e.getMessage());
            request.getRequestDispatcher("category-register.jsp").forward(request, response);
        }
    }
}