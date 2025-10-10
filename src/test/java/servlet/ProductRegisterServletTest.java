package servlet;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;

import base.H2TestSupport;

public class ProductRegisterServletTest extends H2TestSupport {

	@Test
	void 正常登録でPRG() throws Exception {
		ProductRegisterServlet servlet = new ProductRegisterServlet();
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		HttpSession ses = mock(HttpSession.class);

		when(req.getParameter("name")).thenReturn("テスト商品");
		when(req.getParameter("price")).thenReturn("1200");
		when(req.getParameter("stock")).thenReturn("5");
		when(req.getParameter("categoryId")).thenReturn("1");
		when(req.getSession()).thenReturn(ses);
		when(req.getContextPath()).thenReturn("");

		servlet.doPost(req, res);

		verify(ses).setAttribute(eq("flash"), anyString());
		verify(res).sendRedirect("/products");
	}

	@Test
	void 不正入力でフォームに戻る() throws Exception {
		ProductRegisterServlet servlet = new ProductRegisterServlet();
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);

		when(req.getParameter("name")).thenReturn("");
		when(req.getRequestDispatcher("/productForm.jsp")).thenReturn(rd);

		servlet.doPost(req, res);

		verify(req).setAttribute(eq("error"), anyString());
		verify(rd).forward(req, res);
	}
}
