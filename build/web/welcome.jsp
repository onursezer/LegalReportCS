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
  <script src="js/welcome.js"></script>
 <link href="css/welcome.css" rel="stylesheet" type="text/css" media="all" />
 <link href="css/table.css" rel="stylesheet" type="text/css" media="all" />
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
		  
                    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
                    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
                    <br />
                    <div class="container">
                            <div class="row">
                                <div class="ui-widget">
                                    <label>Procedure: </label>
                                    <select id="combobox">
                                        <option></option>
                                            
                                            <% 
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
                                            %>
                                                      <option value="<%=name%>"><%=name%></option>
                                            <%
                                                 }
                                            }catch(Exception e)
                                            {    out.print(e);
                                            }
                                            %>
           
                                    </select>
                                </div>
                            </div>
                    </div>
                    
		</div>

		<div class = "container">
		
			<h3>Login successful!!!</h3>
		    <h4>
		        Hello,
		        <%=session.getAttribute("name")%>
                    </h4>
		        
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
                <div class="container">
                    <div class="row">
                            <h2>FIxed Header Table/ Scroll Table Body</h2>

                            <table class="points_table">
                                    <thead>
                                            <tr>
                                                    <th class="col-xs-1">#</th>
                                                    <th class="col-xs-7">Team</th>
                                                    <th class="col-xs-1">S</th>
                                                    <th class="col-xs-1">M</th>
                                                    <th class="col-xs-1">L</th>
                                                    <th class="col-xs-1">O</th>
                                            </tr>
                                    </thead>

                                    <tbody class="points_table_scrollbar">
                                            <tr class="odd">
                                                    <td class="col-xs-1">1</td>
                                                    <td class="col-xs-7">Test Points</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="even">
                                                    <td class="col-xs-1">2</td>
                                                    <td class="col-xs-7">Test Points 2</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="odd">
                                                    <td class="col-xs-1">3</td>
                                                    <td class="col-xs-7">Test Points 3</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="even">
                                                    <td class="col-xs-1">4</td>
                                                    <td class="col-xs-7">Test Points 4</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="odd">
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-7">Test Points 5</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="even">
                                                    <td class="col-xs-1">6</td>
                                                    <td class="col-xs-7">Test Points 6</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="odd">
                                                    <td class="col-xs-1">7</td>
                                                    <td class="col-xs-7">Test Points 7</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="even">
                                                    <td class="col-xs-1">8</td>
                                                    <td class="col-xs-7">Test Points 8</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="odd">
                                                    <td class="col-xs-1">9</td>
                                                    <td class="col-xs-7">Test Points 9</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="even">
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-7">Test Points 10</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="odd">
                                                    <td class="col-xs-1">11</td>
                                                    <td class="col-xs-7">Test Points 11</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="even">
                                                    <td class="col-xs-1">12</td>
                                                    <td class="col-xs-7">Test Points 12</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="odd">
                                                    <td class="col-xs-1">13</td>
                                                    <td class="col-xs-7">Test Points 13</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="even">
                                                    <td class="col-xs-1">14</td>
                                                    <td class="col-xs-7">Test Points 14</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="odd">
                                                    <td class="col-xs-1">15</td>
                                                    <td class="col-xs-7">Test Points 15</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="even">
                                                    <td class="col-xs-1">16</td>
                                                    <td class="col-xs-7">Test Points 16</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="odd">
                                                    <td class="col-xs-1">17</td>
                                                    <td class="col-xs-7">Test Points 17</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="even">
                                                    <td class="col-xs-1">18</td>
                                                    <td class="col-xs-7">Test Points 18</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="odd">
                                                    <td class="col-xs-1">19</td>
                                                    <td class="col-xs-7">Test Points 19</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>

                                            <tr class="even">
                                                    <td class="col-xs-1">20</td>
                                                    <td class="col-xs-7">Test Points 20</td>
                                                    <td class="col-xs-1">10</td>
                                                    <td class="col-xs-1">0</td>
                                                    <td class="col-xs-1">5</td>
                                                    <td class="col-xs-1">1</td>
                                            </tr>
                                    </tbody>
                            </table>
                    </div>
                </div>
                
                <div class="container">
                    
                        <p> </br> </br> </br></br> </br> </br>   </p>
                </div>
                    
    </body>
</html>

