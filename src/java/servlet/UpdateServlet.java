/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.UpdateData;
import dao.UpdateDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean bDate = false, bData = false;
        UpdateDao uDao = new UpdateDao();
        HttpSession session = request.getSession(); 
        String reportCode = (String) session.getAttribute("tableQuery");
        System.out.println(reportCode);
        
        String datepicker =  request.getParameter("datepicker");
        System.out.println("updateText: " + datepicker);
        bDate = uDao.updateDate(datepicker, reportCode);    /// update date
        session.setAttribute("date", datepicker);
        
        
        int count = (int) session.getAttribute("rowCount");
        System.out.println(count);
        String row = "row";
        String rowName = "";
        List <String> list = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            rowName = row + Integer.toString(i+1);
            list.add(request.getParameter( rowName) );
            System.out.println("row: " + request.getParameter(rowName));
        }

        List<UpdateData> listNewData = (List<UpdateData>) session.getAttribute("listData");
        bData = uDao.updateParameterValue(list, listNewData);
        
        if(bDate == true && bData == true){
            session.setAttribute("noticeUpdate", "true");
        }
        else
           session.setAttribute("noticeUpdate", "false"); 
        
        RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
        rd.forward(request, response);
    }
}
