package servlet;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;

import base.H2TestSupport;

public class LoginServletTest extends H2TestSupport {

    @Test
    void 正しい資格情報でログインできる() throws Exception {
        LoginServlet servlet = new LoginServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        HttpSession ses = mock(HttpSession.class);

        when(req.getParameter("username")).thenReturn("admin");
        when(req.getParameter("password")).thenReturn("adminpass");
        when(req.getSession(true)).thenReturn(ses);
        when(req.getContextPath()).thenReturn("");

        servlet.doPost(req, res);

        verify(ses).setAttribute(eq("loginUser"), any());
        verify(res).sendRedirect("/products");
    }

    @Test
    void 誤った資格情報でエラー() throws Exception {
        LoginServlet servlet = new LoginServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        RequestDispatcher rd = mock(RequestDispatcher.class);

        when(req.getParameter("username")).thenReturn("admin");
        when(req.getParameter("password")).thenReturn("wrong");
        when(req.getRequestDispatcher("/login.jsp")).thenReturn(rd);

        servlet.doPost(req, res);

        verify(req).setAttribute(eq("error"), anyString());
        verify(rd).forward(req, res);
        verify(res, never()).sendRedirect(anyString());
    }
}
