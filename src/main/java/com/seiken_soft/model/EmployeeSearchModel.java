package com.seiken_soft.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeSearchModel {
 
	/**
	 * 全件検索
	 * @return 情報リスト
	 * @throws Exception 
	 */
	
	List<ShainList> searchPost(String shainName,String shainId) throws SQLException, Exception;
	
	Connection getCon() throws SQLException;
	
}
