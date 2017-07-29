/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.PrepareDataDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author onur.sezer
 */
public class PrepareDataServlet extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("preore data");
        PrepareDataDao pDao = new PrepareDataDao();
        HttpSession session = request.getSession(); 
        String reportCode = (String) session.getAttribute("tableQuery");
        
        if(pDao.prepareData(reportCode)){
            System.out.println("prepare data geldiimmmm");
            session.setAttribute("waitBar", "true");
        }else{
            session.setAttribute("noticeData", "false");
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
        rd.forward(request, response);
    }


}
