package com.seiken_soft.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeUpdateModelImpl {
	/**
	 * 全件検索
	 * @return 情報リスト
	 * @throws Exception 
	 */
	public Boolean update(String shainName,String shainId,String emailAddress,Connection conn) throws Exception {
		// SQL文
		String sql = "UPDATE m_employee SET EMPLOYEE_NAME = '" + shainName + "',E_MAILADDRESS = '" + emailAddress + "' WHERE EMPLOYEE_ID = '" + shainId + "';";
		//if(shainName.isEmpty()&&shainId.isEmpty()) {
	    //sql = "SELECT * FROM m_employee";
		//}		
		
		// SQL取得結果リスト
		//var shainList = new ArrayList<ShainList>();
		// DB接続～SQL実行結果取得
	
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
		 
		return true;
	}

}
