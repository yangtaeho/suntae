package com.groupware.sun.department.service;

import java.util.HashMap;
import java.util.List;

import com.groupware.sun.common.util.Paging;
import com.groupware.sun.department.dto.Department;

public interface DepartmentService {

	public HashMap<String, Object> departmentRegist(String Department_name);

	public int departmentCount(HashMap<String, Object> param);

	public List<Department> departmentGetList(Paging paging);

	public Department departmentDetail(String Department_name);

	public HashMap<String, Object> departmentUpdate(HashMap<String, Object> param);

	public HashMap<String, Object> departmentDelete(int Department_no);
}
