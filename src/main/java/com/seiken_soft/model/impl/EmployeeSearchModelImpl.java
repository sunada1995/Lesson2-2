package com.seiken_soft.model.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seiken_soft.model.EmployeeSearchModel;
import com.seiken_soft.model.ShainList;

public class EmployeeSearchModelImpl implements EmployeeSearchModel {

	private static String DB_URL = "jdbc:mysql://localhost:3306/Lesson02DB";
	private static String DB_USER = "root";
	private static String DB_PASS = "sunadaru4562";
	
	/**
	 * 全件検索
	 * @return 情報リスト
	 * @throws Exception 
	 */
	//DBコネクション
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
	public List<ShainList> searchPost(String shainName,String shainId) throws SQLException, Exception {
	     
		//インターフェース(EmployeeSearchModel)を継承したクラス
		EmployeeSearchModelImpl employeeSearchModelImpl = new EmployeeSearchModelImpl();
		List<ShainList> shainList = employeeSearchModelImpl.findAll(shainName,shainId,getCon());		  
		
	    return shainList;
	    
	}
	
    //DB接続からSQL発行して取得した値を返却	
	public List<ShainList> findAll(String shainName,String shainId,Connection conn) throws Exception {
		// SQL文
		String sql = "SELECT * FROM m_employee";
		if(!shainName.isEmpty()&&!shainId.isEmpty()) {
			sql = "SELECT * FROM m_employee WHERE EMPLOYEE_NAME LIKE '" + shainName + "%' AND EMPLOYEE_ID = '" + shainId + "';";
		}
		if(!shainName.isEmpty()&&shainId.isEmpty()) {
			sql = "SELECT * FROM m_employee WHERE EMPLOYEE_NAME LIKE '" + shainName + "%';";
		}
		if(shainName.isEmpty()&&!shainId.isEmpty()) {
			sql = "SELECT * FROM m_employee WHERE EMPLOYEE_ID = '" + shainId + "';";
		}
		
		// SQL取得結果リスト
		var shainList = new ArrayList<ShainList>();
		// DB接続～SQL実行結果取得
		 try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// 各カラム情報を取得
				String id = rs.getString("EMPLOYEE_ID");
				String name = rs.getString("EMPLOYEE_NAME");
				String email = rs.getString("E_MAILADDRESS");
				String process = "修正";
				
				var shainData = new ShainList(id,name,email,process);
				// 社員情報を格納
				shainList.add(shainData);
			}

		} catch (SQLException e) {
			throw e;
		}

		return shainList;
	}


}
