package org.movie.recommend.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.movie.recommend.config.DBConfig;

public class DBHelper {
	protected DBConfig db=DBConfig.getDBInstance();
	protected Connection conn=DBConfig.getConnection();
    protected PreparedStatement stmt=DBConfig.getStatement();
    protected ResultSet rs=DBConfig.getResultSet();
    protected CallableStatement clst = DBConfig.getClst();
}
