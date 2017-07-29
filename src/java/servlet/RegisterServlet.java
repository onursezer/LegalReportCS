package servlet;

import bean.Person;
import dao.LoginDao;
import dao.RegisterDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RegisterDao rDao = new RegisterDao();

        Person person = new Person();
        person.setUsername(request.getParameter("username"));
        person.setAuthority(request.getParameter("role"));
        person.setDepartment(request.getParameter("department"));
        person.setPassword(request.getParameter("password"));
        person.setConfirmPassword(request.getParameter("confirm"));

        HttpSession session = request.getSession(true);
        List<String> notice = new LinkedList<String>(); 
        if (rDao.insertUserToDB(person, notice)) {
            if (session != null) {
                session.setAttribute("register", "true");
                session.setAttribute("notice", notice.get(0));
                System.out.println("true");
            }
            System.out.println(notice.get(0));
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        } else {
            if (session != null) {
                session.setAttribute("register", "false");  
                session.setAttribute("notice", notice.get(0));
                System.out.println("false");
            }
            System.out.println(notice.get(0));
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.include(request, response);
        }   

        out.close();
    }
}
