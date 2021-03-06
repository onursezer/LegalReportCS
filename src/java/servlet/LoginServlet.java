package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.LoginDao;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String pass = request.getParameter("userpass");

        HttpSession session = request.getSession(true);
        if (LoginDao.validate(username, pass)) {

            if (session != null) {
                session.setAttribute("name", username);
                session.setAttribute("tableQuery", " ");
                session.setAttribute("login", "true");
                session.setAttribute("date", "");
                session.setAttribute("register", " ");
                session.setAttribute("noticeData","");
                session.setAttribute("noticeUpdate","");
                session.setAttribute("nameOfReport", " ");
                session.setAttribute("waitBar", " ");
            }
            if(LoginDao.isAdmin(username))
                session.setAttribute("admin", "true");
            else
                session.setAttribute("admin", "false");
            
            response.sendRedirect("welcome.jsp");
        } else {
            if (session != null) {
                session.setAttribute("login", "false");
            }
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            out.print("<p style=\"color:red\">Sorry username or password error</p>");
            rd.include(request, response);
        }

        out.close();
    }
}
