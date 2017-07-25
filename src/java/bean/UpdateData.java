/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author onur.sezer
 */
public class UpdateData {
    
    private String rowName;
    private String parameterName;
    private String reportCode;
    private String value;

    public UpdateData(String rowName, String parameterName, String reportCode, String value) {
        this.rowName = rowName;
        this.parameterName = parameterName;
        this.reportCode = reportCode;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    
    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String repoerCode) {
        this.reportCode = repoerCode;
    }
    
    
    
    
}
