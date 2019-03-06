package com.cg.hr.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.hr.core.exceptions.empException;

public class JDBCUtil {
	private Connection connect;
	
	public JDBCUtil() throws empException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@LocalHost:1521:XE";
			String userName="system";
			String password="Capgemini123";
			connect=DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new empException("Wrong in JDBCUtil",e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new empException("Wrong in JDBCUtil",e);
		}
	}

	public Connection getConnect() {
		return connect;
	}
	
}
