package com.seiken_soft.model;

import java.sql.Connection;
import java.sql.SQLException;

public interface EmployeeUpdateModel {

	Connection getCon() throws SQLException;
	
	Boolean update(String shainName,String shainId,String emailAddress,Connection conn) throws SQLException;
}
