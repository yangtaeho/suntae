package com.groupware.sun.department.dao;

import java.util.HashMap;
import java.util.List;

import com.groupware.sun.department.dto.Department;

public interface DepartmentDAO {

	public int departmentRegist(String department_name);

	public int departmentCount(HashMap<String, Object> param);

	public List<Department> departmentGetList(HashMap<String, Object> hashMap);

	public Department departmentDetail(String department_name);

	public int departmentUpdate(HashMap<String, Object> param);

	public int departmentDelete(int department_no);

}
