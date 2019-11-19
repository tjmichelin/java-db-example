package com.unesp.feg.esw.sqltut.database;

import java.sql.SQLException;

public class SQLiteDB extends Db {
	private final String driverForClass = "org.sqlite.JDBC";
	private final String jdbc = "jdbc:sqlite:";
	
	public SQLiteDB(String filePath) throws ClassNotFoundException, SQLException {
		StringBuffer dbUrl = new StringBuffer(this.jdbc);
		dbUrl.append(filePath);
		
		this.init(driverForClass, dbUrl.toString());
	}
}
