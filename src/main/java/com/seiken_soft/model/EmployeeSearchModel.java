package com.seiken_soft.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.seiken_soft.model.impl.EmployeeSearchModelImpl;

public interface EmployeeSearchModel {
 	
	public List<EmployeeSearchModelImpl> selectMany(int shainId,String shainName) throws DataAccessException;
	
}
