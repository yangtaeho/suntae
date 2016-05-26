package com.groupware.sun.employee_status.service;

import java.util.HashMap;
import java.util.List;

import com.groupware.sun.common.util.Paging;
import com.groupware.sun.employee_status.dto.Employee_status;

public interface Employee_statusService {

	public HashMap<String, Object> employee_statusRegist(String employee_status_name);

	public int employee_statusCount(HashMap<String, Object> param);

	public List<Employee_status> employee_statusGetList(Paging paging);

	public Employee_status employee_statusDetail(String employee_status_name);

	public HashMap<String, Object> employee_statusUpdate(HashMap<String, Object> param);

	public HashMap<String, Object> employee_statusDelete(int employee_status_no);
}
