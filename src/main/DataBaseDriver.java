package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class DataBaseDriver {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;

	private ResultSet rset;
	
	
	public void initializeDatabase() {
		String username = "orcluser";
		String password = "jdbcuser";
		String queryID = "select email, FIRST_NAME, LAST_NAME, salary"
				+ " from Employees "
				+ "where employee_id = ?";

		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:"+username+"/"
					+password+"@localhost:1521/xepdb1");

			conn = ods.getConnection();
			//Use the connection to create a statement
			//Используем соединение для создания statement
			pstmt = conn.prepareStatement(queryID);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
