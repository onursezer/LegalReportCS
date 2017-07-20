
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
			body  {
			 background-color: #cccccc;
			}
		</style>
    </head>
    <body>
        <br/><br/><br/><br/><br/>
        <form action="loginServlet" method="post">
            <table align="center">

                <tr>
                    <td colspan="2"><h2>Giriş Sayfasi</h2></td>
                </tr>
                <tr>
                    <td>Kullanici</td>
                    <td><input type="text" name="username" required="required" /></td>
                </tr>
                <tr>
                    <td>Sifre</td>
                    <td><input type="password" name="userpass" required="required" /></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" value="Giriş Yap" /></td>
                </tr>
            </table>
        </form>

    </body>
</html>