package servlet;

import static org.mockito.Mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;

import base.H2TestSupport;
import model.User;

public class ProductListServletTest extends H2TestSupport {

	@Test
	void ログイン済みは一覧へ() throws Exception {
		ProductListServlet servlet = new ProductListServlet();
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		HttpSession ses = mock(HttpSession.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);

		when(req.getSession()).thenReturn(ses);
		when(ses.getAttribute("loginUser")).thenReturn(new User());
		when(req.getRequestDispatcher("/productList.jsp")).thenReturn(rd);

		servlet.doGet(req, res);

		verify(rd).forward(req, res);
	}

	@Test
	void 未ログインはリダイレクト() throws Exception {
		ProductListServlet servlet = new ProductListServlet();
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		HttpSession ses = mock(HttpSession.class);

		when(req.getSession()).thenReturn(ses);
		when(ses.getAttribute("loginUser")).thenReturn(null);
		when(req.getContextPath()).thenReturn("");

		servlet.doGet(req, res);

		verify(res).sendRedirect("/login");
	}
}
