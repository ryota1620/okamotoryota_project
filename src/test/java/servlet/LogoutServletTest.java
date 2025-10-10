package servlet;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;

import base.H2TestSupport;

public class LogoutServletTest extends H2TestSupport {
	@Test
	void セッション破棄してログインへ() throws Exception {
		LogoutServlet servlet = new LogoutServlet();
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		HttpSession ses = mock(HttpSession.class);

		when(req.getSession(false)).thenReturn(ses);
		when(req.getContextPath()).thenReturn("");

		servlet.doPost(req, res);

		verify(ses).invalidate();
		verify(res).sendRedirect("/login");
	}
}
