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
        
        String tableQuery = request.getParameter("search");
        System.out.println( "asd : " + tableQuery  );
        System.out.println("denememe");
        
        
        HttpSession session = request.getSession(false);
        if(session!=null){
                session.setAttribute("tableQuery", tableQuery);
        }
        else
            System.out.println("sesion error");

        SearchDao sDao = new SearchDao();
        session.setAttribute("date", sDao.getDate(tableQuery));  
        
        RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
        rd.forward(request, response);
    }

}
