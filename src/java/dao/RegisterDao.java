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

/**
 *
 * @author onur.sezer
 */
public class RegisterDao {

    public static boolean insertUserToDB(Person person) {

            boolean status = false;
            Connection conn = null;
            PreparedStatement pst = null;

            if( !(person.getPassword().equals(person.getConfirmPassword())) ){
                System.out.println("Hata");
               return false; 
            }
               
            System.out.println(person);
            try {
                    String insertTableSQL = "insert into deneme_persons(username, password, role, department)"
                             + " values(?, ?, ?, ?)";
                           
                    conn = ConnectionHelper.getInstance().getConnection();
                    pst = conn.prepareStatement(insertTableSQL);
                    
                    pst.setString(1, person.getUsername());
                    pst.setString(2, person.getPassword());
                    pst.setString(3, person.getRole());
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
}
