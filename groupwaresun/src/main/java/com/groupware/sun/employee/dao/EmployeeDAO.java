package com.groupware.sun.employee.dao;

import java.util.HashMap;
import java.util.List;

import com.groupware.sun.employee.dto.Employee;

public interface EmployeeDAO {

	public int employeeRegist(HashMap<String, Object> param);

	public int employeeCount(HashMap<String, Object> param);

	public List<Employee> employeeGetList(HashMap<String, Object> param);

	public int employeeUpdate(HashMap<String, Object> param);

	public Employee employeeDetail(HashMap<String, Object> param);

	public int employeeDelete(HashMap<String, Object> param);
	/*
	 * public Employee employeeDetail(int employee_no);
	 * 
	 * public int employeeUpdate(HashMap<String, Object> param);
	 * 
	 * public int employeeDelete(HashMap<String, Object> param);
	 */
}
