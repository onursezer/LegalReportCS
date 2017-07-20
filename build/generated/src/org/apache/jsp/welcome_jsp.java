package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("  <title>Legal Report</title>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("  <script src=\"js/welcome.js\"></script>\r\n");
      out.write(" <link href=\"css/welcome.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("</head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("\t\t<nav class=\"navbar navbar-inverse\">\r\n");
      out.write("\t\t  <div class=\"container-fluid\">\r\n");
      out.write("\t\t    <div class=\"navbar-header\">\r\n");
      out.write("\t\t      <a class=\"navbar-brand\" href=\"welcome.jsp\">Legal Report</a>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t    <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t      <li><a href=\"register.jsp\"><span class=\"glyphicon glyphicon-user\"></span> Register</a></li>\r\n");
      out.write("\t\t      <li><a href=\"index.jsp\"><span class=\"glyphicon glyphicon-log-in\"></span> Logout</a></li>\r\n");
      out.write("\t\t    </ul>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("  \r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t  \r\n");
      out.write("                    <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\r\n");
      out.write("                    <script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
      out.write("                    <br />\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"ui-widget\">\r\n");
      out.write("                                    <label>Procedure: </label>\r\n");
      out.write("                                    <select id=\"combobox\">\r\n");
      out.write("                                        <option></option>\r\n");
      out.write("<!--                                            <option value=\"Ultrasound Knee Right\">Ultrasound Knee Right</option>\r\n");
      out.write("                                            <option value=\"Ultrasound Knee Left\">Ultrasound Knee Left</option>\r\n");
      out.write("                                            <option value=\"Ultrasound Forearm/Elbow Right\">Ultrasound Forearm/  Elbow Right</option>\r\n");
      out.write("                                            <option value=\"Ultrasound Forearm/Elbow Left\">Ultrasound Forearm/Elbow Left</option>\r\n");
      out.write("                                            <option value=\"MRI Knee Right\">MRI Knee Right</option>\r\n");
      out.write("                                            <option value=\"MRI Knee Left\">MRI Knee Left</option>\r\n");
      out.write("                                            <option value=\"MRI Forearm/Elbow Right\">MRI Forearm/Elbow Right</option>\r\n");
      out.write("                                            <option value=\"MRI Forearm/Elbow Left\">MRI Forearm/Elbow Left</option>\r\n");
      out.write("                                            <option value=\"CT Knee Right\">CT Knee Right</option>\r\n");
      out.write("                                            <option value=\"CT Knee Left\">CT Knee Left</option>\r\n");
      out.write("                                            <option value=\"CT Forearm/Elbow Right\">CT Forearm/Elbow Right</option>\r\n");
      out.write("                                            <option value=\"CT Forearm/Elbow Left\">CT Forearm/Elbow Left</option>-->\r\n");
      out.write("\r\n");
      out.write("                                            \r\n");
      out.write("                                            ");
 
                                            Connection con=null;
                                            ResultSet rs2=null;
                                            PreparedStatement pst = null;  
                                            try
                                            {
                                                 con = ConnectionHelper.getInstance().getConnection();
//                                                 HttpSession ss=request.getSession();
//                                                 String uid=(String)ss.getAttribute("id");
                                                 pst=con.prepareStatement("select username from deneme_persons");
                                                 rs2=pst.executeQuery();
                                                 while(rs2.next())
                                                 {
                                                      String name = rs2.getString("username");
                                            
      out.write("\r\n");
      out.write("                                                      <option value=\"");
      out.print(name);
      out.write('"');
      out.write('>');
      out.print(name);
      out.write("</option>\r\n");
      out.write("                                            ");

                                                 }
                                            }catch(Exception e)
                                            {    out.print(e);
                                            }
                                            
      out.write("\r\n");
      out.write("                                            \r\n");
      out.write("                                           \r\n");
      out.write("                                                \r\n");
      out.write("                                                \r\n");
      out.write("\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class = \"container\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<h3>Login successful!!!</h3>\r\n");
      out.write("\t\t    <h4>\r\n");
      out.write("\t\t        Hello,\r\n");
      out.write("\t\t        ");
      out.print(session.getAttribute("name"));
      out.write("</h4>\r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t        <table width=\"59%\" border=\"1\">\r\n");
      out.write("\t\t\t\t    ");

				        LoginDao lDao = new LoginDao();
				        Connection conn = ConnectionHelper.getInstance().getConnection();   
				        
				        Statement stmt = conn.createStatement();
                                        ResultSet rs = stmt.executeQuery("select * from DENEME_PERSONS");
                                        ResultSetMetaData rsmd = rs.getMetaData();
			           
			     
				        
				        while(rs.next())
				        {
				            
      out.write("\r\n");
      out.write("\t\t\t                <tr>\r\n");
      out.write("\t\t\t                 ");

			                 for(int i = 1; i<=rsmd.getColumnCount();i++)
			                    { 
      out.write("\r\n");
      out.write("\t\t\t                     <td>\r\n");
      out.write("\t\t\t                     ");
      out.print( rs.getString(i));
      out.write("\r\n");
      out.write("\t\t\t                     </td>\r\n");
      out.write("\t\t\t                ");
 
			                    }
			                
      out.write("                   \r\n");
      out.write("\t\t\t                </tr>\r\n");
      out.write("\t\t\t            ");
 
			        	}
			    	
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
