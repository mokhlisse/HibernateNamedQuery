package com.mokhlisse.hibernatenamedquery.dao;

import java.util.List;

import com.mokhlisse.hibernatenamedquery.dao.impl.DepartmentNotFoundException;
import com.mokhlisse.hibernatenamedquery.model.Department;

public interface DepartmentDao {

	/**
	 * return total Departments number
	 * 
	 * @return
	 */
	public long getTotalDept();

	/**
	 * get department name by id
	 * 
	 * @param id
	 * @return
	 * @throws DepartmentNotFoundException 
	 */
	public String getDeptNameById(int id) throws DepartmentNotFoundException;

	/**
	 * get all departments
	 * 
	 * @return
	 */
	public List<Department> getAllDepartement();
}
