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
import java.util.List;

/**
 *
 * @author onur.sezer
 */
public class RegisterDao {

    public boolean insertUserToDB(Person person, List<String> notice) {

        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;

        if (person.getAuthority().equals("") || person.getConfirmPassword().equals("")
                || person.getPassword().equals("") || person.getUsername().equals("")) {
            notice.add("There were problems creating account. Missing entry !");
            System.out.println("eksik");
            return false;
        }

        if (!(person.getPassword().equals(person.getConfirmPassword()))) {
            notice.add("There were problems creating account. Password does not match !");
            System.out.println("Hata");
            return false;
        }

        if (isUser(person.getUsername())) {
            notice.add("There were problems creating account. This account was added before !");
            System.out.println("daha once eklenmis");
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

            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionHelper.getInstance().closePreparedStatement(pst);
            ConnectionHelper.getInstance().closeConnection(conn);
        }
        notice.add("Success. The account was created !");
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
        } finally {
            ConnectionHelper.getInstance().closeResultSet(rs);
            ConnectionHelper.getInstance().closePreparedStatement(pst);
            ConnectionHelper.getInstance().closeConnection(conn);
        }
        return status;
    }
}
