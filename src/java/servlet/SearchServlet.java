/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.SearchDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author onur.sezer
 */
public class SearchServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tableQuery = null;
        String str = request.getParameter("search");        
        
        String[] tokens = str.split(" - ");

        int i = 0;
        for (String t : tokens)
        {
            if(i == 0)
                tableQuery = t;
            System.out.println(t);
            ++i;
        }
        
        HttpSession session = request.getSession(false);
        if(session!=null){
                session.setAttribute("tableQuery", tableQuery);
                session.setAttribute("nameOfReport", str);
        }
        else
            System.out.println("sesion error");

        SearchDao sDao = new SearchDao();
        session.setAttribute("date", sDao.getDate(tableQuery));  
        
        RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
        rd.forward(request, response);
    }

}
