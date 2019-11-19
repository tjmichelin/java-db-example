package com.unesp.feg.esw.sqltut.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class Db {
	private String driver;
	private String dbUrl;
	private Connection conn;
	
	protected void init(String driver, String url) throws ClassNotFoundException, SQLException {
		this.setDriver(driver);
		this.setUrl(url);
		this.setConnection();
	}

	private void setDriver(String driver) {
		this.driver = driver;
	}

	private void setUrl(String url) {
		this.dbUrl = url;
	}

	public void setConnection() throws ClassNotFoundException, SQLException {
		Class.forName(this.driver);
		this.conn = DriverManager.getConnection(this.dbUrl);
	}

	public Connection getConnection() {
		return conn;
	}
	
	public void closeConnection() {
		try {
			this.conn.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
