<%-- 
    Document   : logout
    Created on : Jul 24, 2017, 10:17:09 AM
    Author     : onur.sezer
--%>

<%

    session.invalidate(); 
    response.sendRedirect("index.jsp");
    
%>