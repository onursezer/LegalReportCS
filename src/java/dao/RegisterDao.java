/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author onur.sezer
 */
public class RegisterDao {

    public boolean insertUserToDB(Person person) {

        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;

        if( person.getAuthority().equals("") || person.getConfirmPassword().equals("") ||
                person.getPassword().equals("") || person.getUsername().equals(""))
            return false;
                
        if (!(person.getPassword().equals(person.getConfirmPassword()))) {
            System.out.println("Hata");
            return false;
        }

        if ( isUser(person.getUsername())) {
            return false;
        }
        

        System.out.println(person);
        try {
            String insertTableSQL = "insert into USERAUTHORITY(username, pass, authority, department)"
                    + " values(?, ?, ?, ?)";

            conn = ConnectionHelper.getInstance().getConnection();
            pst = conn.prepareStatement(insertTableSQL);

            pst.setString(1, person.getUsername());
            pst.setString(2, person.getPassword());
            pst.setString(3, person.getAuthority());
            pst.setString(4, person.getDepartment());

            pst.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
            ConnectionHelper.getInstance().closePreparedStatement(pst);
            ConnectionHelper.getInstance().closeConnection(conn);
        }
        System.out.println("gerceklesit");
        return true;
    }

    private boolean isUser(String username) {

        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "select username from USERAUTHORITY where username = ?";

        try {
            conn = ConnectionHelper.getInstance().getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, username);
            rs = pst.executeQuery();
            status = rs.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
}
