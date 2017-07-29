package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.UpdateData;
import dao.UpdateDao;
import java.util.ArrayList;
import java.util.List;
import dao.LoginDao;
import dao.ConnectionHelper;
import java.sql.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\"\r\n");
      out.write("      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\r\n");
      out.write("      xmlns:f=\"http://xmlns.jcp.org/jsf/core\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Legal Report</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"js/welcome.js\"></script>\r\n");
      out.write("        <link href=\"css/welcome.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("        <link href=\"css/table.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\r\n");
      out.write("        <script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        ");

            if (session.getAttribute("login") != null) {
      out.write("\r\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"navbar-header\">\r\n");
      out.write("                    <a class=\"navbar-brand\" href=\"welcome.jsp\">Legal Report</a>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                    ");
 if (session.getAttribute("admin").equals("true")) {
      out.write("\r\n");
      out.write("                    <li><a href=\"register.jsp\"><span class=\"glyphicon glyphicon-user\"></span> Register</a></li>\r\n");
      out.write("                        ");
}
      out.write("\r\n");
      out.write("                    <li> <a href=\"logout.jsp\"><span class=\"glyphicon glyphicon-log-in\"></span> Logout</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("            <div class = \"container\">\r\n");
      out.write("                ");
if (((String) session.getAttribute("noticeData")).equals("true")) {
      out.write("\r\n");
      out.write("                <div class=\"alert alert-success\">\r\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\r\n");
      out.write("                    <span><strong>Notice: </strong> Success. The data was prepared ! </span>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
} else if (((String) session.getAttribute("noticeData")).equals("false")) {
      out.write("\r\n");
      out.write("                <div class=\"alert alert-danger\">\r\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\r\n");
      out.write("                    <span><strong>Notice: </strong> There were problems preparing report. Report not selected ! </span>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
}
                    session.setAttribute("noticeData", " ");
                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                ");
if (((String) session.getAttribute("noticeUpdate")).equals("true")) {
      out.write("\r\n");
      out.write("                <div class=\"alert alert-success\">\r\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\r\n");
      out.write("                    <span><strong>Notice: </strong> Update successful ! </span>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
} else if (((String) session.getAttribute("noticeUpdate")).equals("false")) {
      out.write("\r\n");
      out.write("                <div class=\"alert alert-danger\">\r\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\r\n");
      out.write("                    <span><strong>Notice: </strong> There were problems updating data. Update is not successful ! </span>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
}
                    session.setAttribute("noticeUpdate", "");
                
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"row\">  \r\n");
      out.write("                    ");
if (((String) session.getAttribute("waitBar")).equals("true")) {
      out.write("\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <div class=\"progress\" width=\"20\">\r\n");
      out.write("                            <div class=\"progress-bar progress-bar-striped active\"  role=\"progressbar\" aria-valuenow=\"45\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 100%\">\r\n");
      out.write("                                <h4 class=\"modal-title\" id=\"myModalLabel\"><p id=\"demo\"></p>%</h4>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");
}
                        session.setAttribute("waitBar", " ");
                    
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
} else {
                        response.sendRedirect("index.jsp");
                    }
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <h3>\r\n");
      out.write("                    <kbd> Welcome  ");
      out.print(session.getAttribute("name"));
      out.write(" </kbd>\r\n");
      out.write("\r\n");
      out.write("                </h3>\r\n");
      out.write("                </br>  \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"row\">         \r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("                <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\r\n");
      out.write("                <script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
      out.write("                <br />\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <form action=\"searchServlet\" method=\"post\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"ui-widget\">\r\n");
      out.write("                                <label>Reports: </label>\r\n");
      out.write("                                <select id=\"combobox\" style=\"width: 150px\"  name=\"search\">\r\n");
      out.write("                                    <option> </option>\r\n");
      out.write("\r\n");
      out.write("                                    ");

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

                                    
      out.write("\r\n");
      out.write("                                    <option value=\"");
      out.print(freportCode + " - " + freportName);
      out.write('"');
      out.write('>');
      out.print(freportCode);
      out.write(" - ");
      out.print(freportName);
      out.write("</option>\r\n");
      out.write("                                    ");

                                            }
                                        } catch (Exception e) {
                                            out.print(e);
                                        }
                                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                </select>\r\n");
      out.write("\r\n");
      out.write("                                <!--<input type=\"submit\" value=\"Search\" />-->\r\n");
      out.write("                                <input class=\"btn btn-primary\" type=\"submit\" value=\"Search\">\r\n");
      out.write("                                <!--<button type=\"button\" class=\"btn btn-primary\"><span class=\"glyphicon glyphicon-search\" aria-hidden=\"true\"></span></button>-->\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                </br> </br>\r\n");
      out.write("                <form action=\"updateServlet\" method=\"post\"> \r\n");
      out.write("                    <div class=\"ui-widget\">\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label>Date: &nbsp &nbsp &nbsp</label>\r\n");
      out.write("                            <input type=\"text\"  name=\"datepicker\" id=\"datepicker\" value=");
      out.print(session.getAttribute("date"));
      out.write("   >\r\n");
      out.write("                            <input class=\"btn btn-primary\" type=\"submit\" value=\"Update\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    </br></br></br>\r\n");
      out.write("                    ");

                        if (!(((String) session.getAttribute("nameOfReport")).equals(" "))) {
                    
      out.write("\r\n");
      out.write("                    <h3> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp\r\n");
      out.write("                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp\r\n");
      out.write("                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp\r\n");
      out.write("                        ");
      out.print( "Report : " + session.getAttribute("nameOfReport"));
      out.write("  </h3>\r\n");
      out.write("                        ");
}
      out.write("\r\n");
      out.write("                    <table class=\"table table-hover table-responsive\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th class=\"col-xs-7\">Parameter Name</th>\r\n");
      out.write("                                <th class=\"col-xs-4\">Parameter Value</th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody class=\"points_table_scrollbar\">\r\n");
      out.write("\r\n");
      out.write("                            ");

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
                            
      out.write("\r\n");
      out.write("                            <tr class=\"even\">\r\n");
      out.write("                                ");

                                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                                        if (i == 1) {
                                
      out.write("\r\n");
      out.write("                                <td class=\"col-xs-7\">\r\n");
      out.write("                                    ");
      out.print( rs.getString(i));
      out.write("\r\n");
      out.write("                                </td>\r\n");
      out.write("                                ");

                                } else {
                                
      out.write("\r\n");
      out.write("                                <td class=\"col-xs-4 \">\r\n");
      out.write("                                    ");
System.out.println("rowww : " + rowName);
                                        listNewData.add(new UpdateData(rowName, rs.getString(1), (String) session.getAttribute("tableQuery"), rs.getString(i)));
                                    
      out.write("\r\n");
      out.write("                                    <input type=\"text\" id=\"");
      out.print(rowName);
      out.write("\" name=\"");
      out.print(rowName);
      out.write("\" value=");
      out.print( rs.getString(i));
      out.write(">\r\n");
      out.write("                                </td>\r\n");
      out.write("                                ");

                                    }
                                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                ");

                                    }
                                
      out.write("                   \r\n");
      out.write("                            </tr>\r\n");
      out.write("                            ");

                            } else {
                            
      out.write("           \r\n");
      out.write("                            <tr class=\"odd\">\r\n");
      out.write("                                ");

                                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                                        if (i == 1) {
                                
      out.write("\r\n");
      out.write("                                <td class=\"col-xs-7\">\r\n");
      out.write("                                    ");
      out.print( rs.getString(i));
      out.write("\r\n");
      out.write("                                </td>\r\n");
      out.write("                                ");

                                } else {
                                
      out.write("\r\n");
      out.write("                                <td class=\"col-xs-4 \">\r\n");
      out.write("                                    ");
System.out.println("rowww : " + rowName);
                                        listNewData.add(new UpdateData(rowName, rs.getString(1), (String) session.getAttribute("tableQuery"), rs.getString(i)));
                                    
      out.write("\r\n");
      out.write("                                    <input type=\"text\" id=\"");
      out.print(rowName);
      out.write("\" name=\"");
      out.print(rowName);
      out.write("\" value=");
      out.print( rs.getString(i));
      out.write(">\r\n");
      out.write("                                </td>\r\n");
      out.write("                                ");

                                    }
                                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                ");

                                    }
                                
      out.write("                   \r\n");
      out.write("                            </tr>\r\n");
      out.write("                            ");

                                    }
                                }
                                if (count == 0) {
                            
      out.write("\r\n");
      out.write("                            <tr class=\"even\">\r\n");
      out.write("                                <td class=\"col-xs-7\">           </td>\r\n");
      out.write("                                <td class=\"col-xs-4\">           </td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            ");
 }
                                session.setAttribute("rowCount", count);
                                session.setAttribute("listData", listNewData);
                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>               \r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"kutu\">\r\n");
      out.write("                    <div class=\"kutuBir\">\r\n");
      out.write("\r\n");
      out.write("                        <input   data-toggle=\"modal\" data-target=\"#prepare\"  class=\"btn btn-primary\" type=\"submit\" value=\"Prepare Data\">\r\n");
      out.write("\r\n");
      out.write("                        <!--                        <input  onclick='myFunc()' id='button'  class=\"btn btn-primary\" type=\"submit\" id='button' value=\"Prepare Data\">\r\n");
      out.write("                                                <button style='display:none' id='buttonID' onclick='myFunc()' class='btn btn-danger btn-lg'> </button>-->\r\n");
      out.write("\r\n");
      out.write("                        <!--<button type=\"button\" data-toggle=\"modal\" data-target=\"#prepare\" data-uid=\"2\" class=\"btn btn-primary\" value=\"Prepare Data\"></button>-->\r\n");
      out.write("                        <div id=\"prepare\" class=\"modal fade\" role=\"dialog\">\r\n");
      out.write("                            <div class=\"modal-dialog\">\r\n");
      out.write("                                <div class=\"modal-content\">\r\n");
      out.write("                                    <form id=\"thisone\" action=\"prepareData\" method=\"post\">\r\n");
      out.write("                                        <div class=\"modal-header\">\r\n");
      out.write("                                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\">×</button>\r\n");
      out.write("                                            <h4 class=\"modal-title\">Prepare Data</h4>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"modal-body\">\r\n");
      out.write("                                            <h3> Do you want to prepare the data dated ");
      out.print(session.getAttribute("date"));
      out.write(" ? </h3>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"modal-footer\">\r\n");
      out.write("                                            <input onclick=\"myTimer()\" class=\"btn btn-primary\" type=\"submit\" value=\"Ok\">\r\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"kutuIki\">\r\n");
      out.write("                        <form id=\"thistoo\" method=\"post\"> <form id=\"thistoo\" method=\"post\">\r\n");
      out.write("                                <input onclick=\"GetReportScreen()\" class=\"btn btn-primary\" type=\"submit\" value=\"Get Report\">\r\n");
      out.write("                                <script>\r\n");
      out.write("                                    function GetReportScreen() {\r\n");
      out.write("                                        var txt;\r\n");
      out.write("                                        var r = confirm(\"Do you want to go to the report screen?\");\r\n");
      out.write("                                        if (r == true) {\r\n");
      out.write("                                            window.open('http://10.14.12.221:8080/BOE/BI', \"_blank\");\r\n");
      out.write("                                        } else {\r\n");
      out.write("                                            txt = \"You pressed Cancel!\";\r\n");
      out.write("                                        }\r\n");
      out.write("                                        document.getElementById(\"demo\").innerHTML = txt;\r\n");
      out.write("                                    }\r\n");
      out.write("                                </script>\r\n");
      out.write("                            </form> \r\n");
      out.write("                            <input onclick=\"myTimer()\" type=\"submit\" value=\"deneme\" name=\"deneme\" />\r\n");
      out.write("                            <script>\r\n");
      out.write("                                var myVar = setInterval(function () {\r\n");
      out.write("                                    myTimer()\r\n");
      out.write("                                }, 1);\r\n");
      out.write("                                var count = 0;\r\n");
      out.write("                                function myTimer() {\r\n");
      out.write("                                    if (count < 100) {\r\n");
      out.write("                                        $('.progress').css('width', count + \"%\");\r\n");
      out.write("                                        //count += 0.009;\r\n");
      out.write("                                        count += 0.1;\r\n");
      out.write("                                        document.getElementById(\"demo\").innerHTML = Math.round(count) + \"%\";\r\n");
      out.write("                                        // code to do when loading\r\n");
      out.write("                                    } else if (count > 99) {\r\n");
      out.write("                                        // code to do after loading\r\n");
      out.write("                                        window.open('http://www.google.com.tr', \"_blank\");\r\n");
      out.write("\r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("                            </script>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <p> </br> </br> </br></br> </br> </br>   </p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
