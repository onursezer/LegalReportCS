<%@page import="dao.ConnectionHelper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="tr">
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

        <!-- Website CSS style -->
        <link rel="stylesheet" type="text/css" href="assets/css/main.css">

        <!-- Website Font style -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

        <!-- Google Fonts -->
        <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="./css/register.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Admin</title>
    </head>
    <body>	
        <%
            if (session.getAttribute("login") != null) {  %>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="welcome.jsp">Legal Report</a>
                </div>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                    <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <div class="row main">
                <div class="panel-heading">
                    <div class="panel-title text-center">
                        <div align="center">
                            <h2 class="title">Register</h1> 
                        </div>
                        <hr />
                    </div>
                </div> 
                <div class="main-login main-center">
                    <form class="form-horizontal" action="registerServlet" method="post">

                        <div class="form-group">
                            <label for="username" class="cols-sm-2 control-label">Username</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="confirm" class="cols-sm-2 control-label">Role</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                    <select name="role">
                                        <option value="1">Admin</option>
                                        <option value="0">Regular User</option>
                                    </select>
                                </div>
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="confirm" class="cols-sm-2 control-label">Department</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-university" aria-hidden="true"></i></span>

                                    <select name="department">
                                        <%
                                            Connection con = null;
                                            ResultSet rs2 = null;
                                            PreparedStatement pst = null;
                                            try {
                                                con = ConnectionHelper.getInstance().getConnection();

                                                String sql1 = "select DISTINCT (bank_department) from rasman_sy_legal_report_deneme ";
                                                pst = con.prepareStatement(sql1);
                                                ResultSet rs = pst.executeQuery();

                                                while (rs.next()) {

                                                    String department = rs.getString("bank_department");

                                        %>
                                        <option value="<%=department%>"><%=department%></option>
                                        <%
                                                }
                                            } catch (Exception e) {
                                                out.print(e);
                                            }
                                        %>

                                    </select>







                                </div>
                            </div>
                        </div>



                        <div class="form-group">
                            <label for="password" class="cols-sm-2 control-label">Password</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password"/>
                                </div>
                            </div>
                        </div>



                        <div class="form-group ">
                            <input onclick="AlertUyari()" id="submit" type="submit" class="btn btn-primary btn-lg btn-block login-button" value="Register" />
                        </div>

                    </form>


                </div>

            </div>
        </div>
        <%} else {%>
        <jsp:forward page = "index.jsp" />
        <%}%> 
        <script type="text/javascript" src="assets/js/bootstrap.js"></script> 
        <script>
            function AlertUyari() {
            <%if (session.getAttribute("register") == "true") {%>
                alert("Kayit Basarili...");
            <%} else%>
                alert("Hatali")
            }
        </script> 



    </body>
</html>