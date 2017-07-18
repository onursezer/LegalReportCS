package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao extends ConnectionHelper {

	public boolean validate(String name, String pass) {
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			conn = getInstance().getConnection();
			pst = conn
					.prepareStatement("select * from denemepersons where username=? and password=?");
			pst.setString(1, name);
			pst.setString(2, pass);

			rs = pst.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
			closeResultSet(rs);
			closePreparedStatement(pst);
			closeConnection(conn);

		}
		return status;
	}
}