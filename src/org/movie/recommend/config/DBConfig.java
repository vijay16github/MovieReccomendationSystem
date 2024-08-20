package org.movie.recommend.config;

import java.io.*;
import java.sql.*;
import java.util.Properties;

import org.movie.recommend.config.DBConfig;

public class DBConfig {
	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	private static CallableStatement clst;

	


	public static void main(String x[]) {
		new DBConfig();
	}

	private static DBConfig db = null;

	public DBConfig() {
		try {
//			   File f=new File(".");
//			   String path=(f.getAbsolutePath().substring(0, f.getAbsolutePath().length()-1))+"src\\db.properties";
//			   FileInputStream fin=new FileInputStream(path);
			Properties p = new Properties();
			p.load(PathHelper.fin);
			String driverClassName = p.getProperty("driver.classname");
			String username = p.getProperty("db.username");
			String password = p.getProperty("db.password");
			String url = p.getProperty("db.url");
			System.out.println(PathHelper.fin);
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			if (conn != null) {
				System.out.println("Database is connected");
			} else {
				System.out.println("Database is not connected");
			}
		} catch (Exception ex) {
			System.out.println("error is" + ex);
		}
	}

	public static DBConfig getDBInstance() {
		if (db == null) {
			db = new DBConfig();
		}
		return db;
	}

	public static Connection getConnection() {
		return conn;
	}

	public static PreparedStatement getStatement() {
		return stmt;
	}

	public static ResultSet getResultSet() {
		return rs;

	}

	public static CallableStatement getClst() {
				return clst;
		   
	   }
	}
