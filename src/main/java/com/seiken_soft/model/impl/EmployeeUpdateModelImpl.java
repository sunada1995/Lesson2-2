package com.seiken_soft.model.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.seiken_soft.model.EmployeeUpdateModel;

public class EmployeeUpdateModelImpl implements EmployeeUpdateModel {
	
	private static String DB_URL = "jdbc:mysql://localhost:3306/Lesson02DB";
	private static String DB_USER = "root";
	private static String DB_PASS = "sunadaru4562";
	/**
	 * 全件検索
	 * @return 情報リスト
	 * @throws SQLException 
	 * @throws Exception 
	 */
	@Override
	public Connection getCon() throws SQLException{
		try {
			// JDBCドライバーのクラスをロード ①
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException("JDBCドライバーのロードに失敗しました", e);
		}

		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS); // ②
	}
	
	@Override
	public Boolean update(String shainName,String shainId,String emailAddress,Connection conn) throws SQLException{
		// SQL文
		try {
			String sql = "UPDATE m_employee SET EMPLOYEE_NAME = '" + shainName + "', E_MAILADDRESS = '" + emailAddress + "' WHERE EMPLOYEE_ID = '" + shainId + "';";

			// DB接続～SQL実行結果取得
		
		    PreparedStatement stmt = conn.prepareStatement(sql);
			int rs = stmt.executeUpdate();
			 
		}catch(SQLException e){
			throw e;
		}
		
		return true;
	}

}
 