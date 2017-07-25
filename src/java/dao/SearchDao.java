/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author onur.sezer
 */
public class SearchDao {
    
    public String getDate(String reportCode){

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String date = null;
        try {
            String query = "select prm_value from rasman_sy_report_deneme where prm_owner = ?";

            conn = ConnectionHelper.getInstance().getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1,reportCode);

            pst.executeQuery();
            rs = pst.executeQuery();
            
            while(rs.next())
                date = rs.getString("prm_value");               
            

            
        } catch (Exception e) {
            System.out.println(e);
        }
         finally {
            ConnectionHelper.getInstance().closeResultSet(rs);
            ConnectionHelper.getInstance().closePreparedStatement(pst);
            ConnectionHelper.getInstance().closeConnection(conn);
        }
        return date;
    }
}
