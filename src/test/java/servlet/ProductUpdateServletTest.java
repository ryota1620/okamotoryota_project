package servlet;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import base.H2TestSupport;
import dao.DB;

public class ProductUpdateServletTest extends H2TestSupport {

    @BeforeEach
    void seed() throws Exception {
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(
                  "INSERT INTO products(name,price,stock,category_id) VALUES('変更前',100,1,1)")) {
            ps.executeUpdate();
        }
    }

    @Test
    void 更新してPRG() throws Exception {
        ProductUpdateServlet servlet = new ProductUpdateServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        HttpSession ses = mock(HttpSession.class);

        when(req.getParameter("id")).thenReturn("4"); // data.sqlの3件 + 1件
        when(req.getParameter("name")).thenReturn("変更後");
        when(req.getParameter("price")).thenReturn("200");
        when(req.getParameter("stock")).thenReturn("2");
        when(req.getParameter("categoryId")).thenReturn("2");
        when(req.getSession()).thenReturn(ses);
        when(req.getContextPath()).thenReturn("");

        servlet.doPost(req, res);

        verify(ses).setAttribute(eq("flash"), anyString());
        verify(res).sendRedirect("/products");
    }
}
