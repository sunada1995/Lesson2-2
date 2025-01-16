package com.seiken_soft.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seiken_soft.model.ShainList;

public class EmployeeSearchModelImpl {

	
	
	/**
	 * 全件検索
	 * @return 情報リスト
	 * @throws Exception 
	 */
	public List<ShainList> findAll(String shainName,String shainId,Connection conn) throws Exception {
		// SQL文
		String sql = "SELECT * FROM m_employee WHERE EMPLOYEE_NAME = '" + shainName + "' OR EMPLOYEE_ID = '" + shainId + "';";
		if(shainName.isEmpty()&&shainId.isEmpty()) {
	    sql = "SELECT * FROM m_employee";
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
