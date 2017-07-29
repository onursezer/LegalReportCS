/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author onur.sezer
 */
public class PrepareDataDao {

    public boolean prepareData(String reportCode) {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String report_no = null;
        
        System.out.println("reportCode : " + reportCode);
        if(reportCode.equals(" "))
        {
            return false;
        }
        try {
            String query = "select report_no from rasman_sy_legal_report_deneme where report_code = ?";
            con = ConnectionHelper.getInstance().getConnection();
            pst = con.prepareStatement(query);
            pst.setString(1, reportCode);
            rs = pst.executeQuery();

            while (rs.next()) {

                report_no = rs.getString("report_no");
            }

            System.out.println("report_no : " + report_no);

            CallableStatement cs = con.prepareCall("begin PROSEDURDENEME('" + report_no + "'); end;");
            cs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.getInstance().closeConnection(con);
            ConnectionHelper.getInstance().closePreparedStatement(pst);
            ConnectionHelper.getInstance().closeResultSet(rs);
        }

        return true;
    }
}
