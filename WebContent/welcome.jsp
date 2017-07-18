<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="dao.LoginDao" %>
<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body>
    <h3>Login successful!!!</h3>
    <h4>
        Hello,
        <%=session.getAttribute("name")%></h4>
        
        
        
        
        <table width="59%" border="1">
		    <%
		        LoginDao lDao = new LoginDao();
		        Connection conn = lDao.getInstance().getConnection();   
		        
		        Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from DENEMEPERSONS");
	            ResultSetMetaData rsmd = rs.getMetaData();
	           
	     
		        
		        while(rs.next())
		        {
		            %>
	                <tr>
	                 <%
	                 for(int i = 1; i<=rsmd.getColumnCount();i++)
	                    { %>
	                     <td>
	                     <%= rs.getString(i)%>
	                     </td>
	                <% 
	                    }
	                %>                   
	                </tr>
	            <% 
	        	}
	    	%>
		</table>



</body>
</html>