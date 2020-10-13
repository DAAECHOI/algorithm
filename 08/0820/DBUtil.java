package com.ssafy.java.d0820;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	final String url = "jdbc:mysql://127.0.0.1:3306/ssafy04_home?serverTimezone=UTC";
	
	private static DBUtil util = new DBUtil();
	public static DBUtil getUtil() {
		return util;
	}
	
	private DBUtil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, "ssafy", "ssafy");
	}
	
	public void close(ResultSet rset, Statement stmt, Connection con) {
		try {
			if(rset != null) {
				rset.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(con != null) {
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
