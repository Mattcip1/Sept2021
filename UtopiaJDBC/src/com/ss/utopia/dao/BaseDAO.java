package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseDAO<T> {

	protected static Connection conn = null;
	
	public BaseDAO(Connection conn) {
		this.conn = conn;
	}
	
	protected void save(String sql, Object[] vals) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if(vals != null) {
			int count = 1;
			for(Object o: vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		pstmt.execute();
	}
	
	protected Integer saveWithPK(String sql, Object[] vals) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		if(vals != null) {
			int count = 1;
			for(Object o: vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		pstmt.execute();
		ResultSet rs = pstmt.getGeneratedKeys();
		while(rs.next()) {
			return rs.getInt(1);
		}
		return null;
	}
	
	protected List<T> read(String sql, Object[] vals) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if(vals != null) {
			int count = 1;
			for(Object o: vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
	}
	
	abstract protected List<T> extractData(ResultSet rs) throws SQLException;
}
