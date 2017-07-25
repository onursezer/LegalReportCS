<%@page import="bean.UpdateData"%>
<%@page import="dao.UpdateDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ page import="dao.LoginDao" %>
<%@ page import="dao.ConnectionHelper" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <title>Legal Report</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/welcome.js"></script>
        <link href="css/welcome.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/table.css" rel="stylesheet" type="text/css" media="all" />
    </head>
    <body>

        <%
            if (session.getAttribute("login") != null) {%>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="welcome.jsp">Legal Report</a>
                </div>

                <ul class="nav navbar-nav navbar-right">
                    <% if (session.getAttribute("admin").equals("true")) {%>
                    <li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                        <%}%>
                    <li> <a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </ul>
            </div>
        </nav>


        <div class = "container">
            <h3>
                Welcome  <%=session.getAttribute("name")%>  
            </h3>
            </br>  
        </div>

        <div class="container">

            <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
            <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
            <br />
            <div class="container">
                <form action="searchServlet" method="post">
                    <div class="row">
                        <div class="ui-widget">
                            <label>Reports: </label>
                            <select id="combobox" style="width: 150px"  name="search">
                                <option></option>

                                <%
                                    Connection con = null;
                                    PreparedStatement pst = null;
                                    List<UpdateData> listNewData = new ArrayList<UpdateData>();
                                    try {
                                        con = ConnectionHelper.getInstance().getConnection();

                                        String sql1 = "select report_code,report_name from rasman_sy_legal_report_deneme "
                                                + "inner join userauthority on rasman_sy_legal_report_deneme.bank_department=userauthority.department where "
                                                + "userauthority.username= '" + session.getAttribute("name") + "'" + " ORDER BY NLSSORT(report_name,'NLS_SORT=turkish')";
                                        pst = con.prepareStatement(sql1);
                                        ResultSet rs = pst.executeQuery();

                                        while (rs.next()) {

                                            String freportCode = rs.getString("report_code");
                                            String freportName = rs.getString("report_name");


                                %>
                                <option value="<%=freportCode%>"><%=freportCode%> - <%=freportName%></option>
                                <%
                                        }
                                    } catch (Exception e) {
                                        out.print(e);
                                    }
                                %>

                            </select>

                            <!--<input type="submit" value="Search" />-->
                            <input class="btn btn-primary" type="submit" value="Search">
                            <!--<button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>-->
                        </div>
                    </div>
                </form>
            </div>

        </div>

        <div class="container">
            </br> </br>
            <form action="updateServlet" method="post"> 
                <div class="ui-widget">
                    <label>Date: &nbsp &nbsp &nbsp</label>
                   
                    <input type="text"  name="updateText" id="updateText"  value=<%=session.getAttribute("date")%>     />
                    <input class="btn btn-primary" type="submit" value="Update">
                </div>
                </br></br></br>
                <table class="table table-hover table-responsive">

                    <thead>
                        <tr>
                            <th class="col-xs-7">Parameter Name</th>
                            <th class="col-xs-4">Parameter Value</th>
                        </tr>
                    </thead>
                    <tbody class="points_table_scrollbar">

                        <%
                        String rowName = null;
                        String row = "row";
                        LoginDao lDao = new LoginDao();
                        Connection conn = ConnectionHelper.getInstance().getConnection();

                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("select a.parameter,a.prm_value from rasman_sy_report_deneme_other "
                                + "a,rasman_sy_legal_report_deneme b where a.report_no=b.report_no and b.report_code = '" + session.getAttribute("tableQuery") + "' order by a.parameter");

                        ResultSetMetaData rsmd = rs.getMetaData();

                        int count = 0;
                        while (rs.next()) {
                            ++count;
                            rowName = row + Integer.toString(count);
                            System.out.println(rowName);
                            if (count % 2 == 0) {
                            %>
                                <tr class="even">
                                    <%
                                        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                                            if (i == 1) {
                                    %>
                                    <td class="col-xs-7">
                                        <%= rs.getString(i)%>
                                    </td>
                                    <%
                                    } else {
                                    %>
                                    <td class="col-xs-4 ">
                                        <%System.out.println("rowww : " + rowName);
                                            listNewData.add(new UpdateData(rowName, rs.getString(1), (String)session.getAttribute("tableQuery"), rs.getString(i)));
                                        %>
                                        <input type="text" id="<%=rowName%>" name="<%=rowName%>" value=<%= rs.getString(i)%>>
                                    </td>
                                    <%
                                        }
                                    %>

                                    <%
                                        }
                                    %>                   
                                </tr>
                                <%
                                } else {
                                %>           
                                <tr class="odd">
                                    <%
                                        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                                            if (i == 1) {
                                    %>
                                    <td class="col-xs-7">
                                        <%= rs.getString(i)%>
                                    </td>
                                    <%
                                    } else {
                                    %>
                                    <td class="col-xs-4 ">
                                        <%System.out.println("rowww : " + rowName);
                                            listNewData.add(new UpdateData(rowName, rs.getString(1), (String)session.getAttribute("tableQuery"), rs.getString(i)));
                                        %>
                                        <input type="text" id="<%=rowName%>" name="<%=rowName%>" value=<%= rs.getString(i)%>>
                                    </td>
                                    <%
                                        }
                                    %>

                                    <%
                                        }
                                    %>                   
                                </tr>
                                <%
                                        }
                                    }
                                    if (count == 0) {
                                %>
                                <tr class="even">
                                    <td class="col-xs-7">           </td>
                                    <td class="col-xs-4">           </td>
                                </tr>
                                <% }
                                session.setAttribute("rowCount", count);
                                session.setAttribute("listData", listNewData);
                                %>
                                    
                    </tbody>
                </table>
            </form>
        </div>

        <div class="container">

            <p> </br> </br> </br></br> </br> </br>   </p>
        </div>
        <%} else {
                response.sendRedirect("index.jsp");
            }%>   

    </body>
</html>
