package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			pst = conn
					.prepareStatement("select * from deneme_persons where username=? and password=?");
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
}