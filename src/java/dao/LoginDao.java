package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDao {

    public LoginDao() {
        // TODO Auto-generated constructor stub
    }

    public static boolean validate(String name, String pass) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = ConnectionHelper.getInstance().getConnection();
            pst = conn.prepareStatement("select * from USERAUTHORITY where username=? and pass=?");
            pst.setString(1, name);
            pst.setString(2, pass);

            rs = pst.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
            ConnectionHelper.getInstance().closeResultSet(rs);
            ConnectionHelper.getInstance().closePreparedStatement(pst);
            ConnectionHelper.getInstance().closeConnection(conn);

        }
        return status;
    }

    public static boolean isAdmin(String username) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = ConnectionHelper.getInstance().getConnection();
            pst = conn.prepareStatement("select * from USERAUTHORITY where username=? and authority=?");
            pst.setString(1, username);
            pst.setString(2, "1");
            
            rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            if(rs.next()){
                System.out.println("LOG: admin");
                status = true;
            }
            else{
                System.out.println("LOG: admin değil");
            }
                
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
}
