<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="dao.LoginDao" %>
<%@ page import="dao.ConnectionHelper" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Legal Report</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="welcome.jsp">Legal Report</a>
		    </div>
		    
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span> Register</a></li>
		      <li><a href="index.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		    </ul>
		  </div>
		</nav>
  
		<div class="container">
		  
		  
		</div>

		<div class = "container">
		
			<h3>Login successful!!!</h3>
		    <h4>
		        Hello,
		        <%=session.getAttribute("name")%></h4>
		        
		        
		        
		        
		        <table width="59%" border="1">
				    <%
				        LoginDao lDao = new LoginDao();
				        Connection conn = ConnectionHelper.getInstance().getConnection();   
				        
				        Statement stmt = conn.createStatement();
			            ResultSet rs = stmt.executeQuery("select * from DENEME_PERSONS");
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
		</div>


</body>
</html>

