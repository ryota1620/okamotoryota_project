package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	req.setCharacterEncoding("UTF-8");
        HttpSession ses = req.getSession(false);
        if (ses != null) ses.invalidate();
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
