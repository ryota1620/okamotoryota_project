package servlet;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import base.H2TestSupport;
import dao.DB;

public class ProductDeleteServletTest extends H2TestSupport {

	@BeforeEach
	void seed() throws Exception {
		try (Connection con = DB.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"INSERT INTO products(name,price,stock,category_id) VALUES('削除対象',999,9,1)")) {
			ps.executeUpdate();
		}
	}

	@Test
	void GETは確認画面へ() throws Exception {
		ProductDeleteServlet servlet = new ProductDeleteServlet();
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);

		when(req.getParameter("id")).thenReturn("4");
		when(req.getRequestDispatcher("/productDeleteConfirm.jsp")).thenReturn(rd);

		servlet.doGet(req, res);

		verify(rd).forward(req, res);
	}

	@Test
	void POSTで削除してPRG() throws Exception {
		ProductDeleteServlet servlet = new ProductDeleteServlet();
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		HttpSession ses = mock(HttpSession.class);

		when(req.getParameter("id")).thenReturn("4");
		when(req.getSession()).thenReturn(ses);
		when(req.getContextPath()).thenReturn("");

		servlet.doPost(req, res);

		verify(ses).setAttribute(eq("flash"), anyString());
		verify(res).sendRedirect("/products");
	}
}
