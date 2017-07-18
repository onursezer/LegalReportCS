package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//  DB ile connection saglar
public class ConnectionHelper {
	private final static String url = "jdbc:oracle:thin:@10.1.3.127:2258:ALFARMUT";
	private final static String driver = "oracle.jdbc.driver.OracleDriver";
	private final static String userName = "test";
	private final static String password = "alfa12345";
	
	private static ConnectionHelper instance = null;
	
	protected ConnectionHelper(){}
	
	public static ConnectionHelper getInstance() {

		if (instance == null) {
			instance = new ConnectionHelper();
		}
		return instance;
	}
	
	public Connection getConnection() throws Exception {
			return getConnectionLocal();
	}

	public Connection getConnectionLocal() throws Exception {
		Connection newConn = null;
		Class.forName(driver);
		newConn = DriverManager.getConnection(url, userName, password);
		return newConn;
	}

	public void closeConnection(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeResultSet(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closePreparedStatement(PreparedStatement pst) {
		try {
			if (pst != null)
				pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
