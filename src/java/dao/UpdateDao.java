/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.UpdateData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author onur.sezer
 */
public class UpdateDao {

    public boolean updateDate(String date, String reportCode) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            String updateTableSQL = "UPDATE rasman_sy_report_deneme SET prm_value = ? where prm_owner = ? ";

            conn = ConnectionHelper.getInstance().getConnection();
            pst = conn.prepareStatement(updateTableSQL);

            pst.setString(1, date);
            pst.setString(2, reportCode);

            pst.executeQuery();
            status = true;

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionHelper.getInstance().closePreparedStatement(pst);
            ConnectionHelper.getInstance().closeConnection(conn);
        }
        return status;
    }

    public boolean updateParameterValue(List<String> prmValue, List<UpdateData> listNewData) {

        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String date = null;
        try {
            
            
            for (int i = 0; i < prmValue.size(); i++) {   // parameter value  guncelleme yeri

                String updateTableSQL = "update rasman_sy_report_deneme_other t set t.prm_value = ? where t.parameter = ?  and t.prm_owner = ? ";
                conn = ConnectionHelper.getInstance().getConnection();
                pst = conn.prepareStatement(updateTableSQL);
                
                System.out.println("prmValue.get(i) : " + prmValue.get(i));
                System.out.println("listNewData.get(i).getParameterName() : " + listNewData.get(i).getParameterName());
                System.out.println("listNewData.get(i).getReportCode() : " + listNewData.get(i).getReportCode());
                pst.setString(1, prmValue.get(i));
                pst.setString(2, listNewData.get(i).getParameterName());
                pst.setString(3, listNewData.get(i).getReportCode());

                pst.executeUpdate();
            }
            status = true;

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionHelper.getInstance().closeResultSet(rs);
            ConnectionHelper.getInstance().closePreparedStatement(pst);
            ConnectionHelper.getInstance().closeConnection(conn);
        }

        return status;
    }
}
