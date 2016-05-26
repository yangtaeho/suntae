package com.groupware.sun.employee.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupware.sun.common.util.AjaxResult;
import com.groupware.sun.common.util.Paging;
import com.groupware.sun.employee.dao.EmployeeDAO;
import com.groupware.sun.employee.dto.Employee;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	// ajax 결과값 Class
	private AjaxResult ajaxResult;

	/*
	 * employee(직원) 등록(관리자가 등록) parameter ->
	 * role_no,employee_status_no,employee_name,employee_id,employee_pw,
	 * employee_hp,employee_email,department_no,team_no,position_no,
	 * employee_activity_no
	 */
	@Override
	public HashMap<String, Object> employeeRegist(HashMap<String, Object> param) {
		int result = 0;
		InetAddress Address;
		try {
			Address = InetAddress.getLocalHost();
			param.put("employee_ip", Address.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		result = employeeDAO.employeeRegist(param);
		this.ajaxResult = new AjaxResult(result);
		HashMap<String, Object> hashMap = ajaxResult.getResultMessage();
		return hashMap;
	}

	// employee(직원) 데이터 갯수
	// parameter -> 검색값 search_sel,search_txt
	@Override
	public int employeeCount(HashMap<String, Object> param) {
		return employeeDAO.employeeCount(param);
	}

	// employee(직원) 리스트 조회
	// parameter -> 검색값 search_sel,search_txt,startRow,endRow
	@Override
	public List<Employee> employeeGetList(Paging paging) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("startRow", paging.getStartRow());
		hashMap.put("endRow", paging.getEndRow());
		hashMap.put("search_sel", paging.getSearch_sel());
		hashMap.put("search_txt", paging.getSearch_txt());
		return employeeDAO.employeeGetList(hashMap);
	}

	// employee(직원) 상세 조회
	// parameter -> employee_no,employee_id
	@Override
	public Employee employeeDetail(int employee_no, String employee_id) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("employee_no", employee_no);
		hashMap.put("employee_id", employee_id);
		return employeeDAO.employeeDetail(hashMap);
	}

	// employee(직원) 수정
	// parameter -> employee_no,employee_id
	@Override
	public HashMap<String, Object> employeeUpdate(HashMap<String, Object> param) {
		int result = 0;
		result = employeeDAO.employeeUpdate(param);
		this.ajaxResult = new AjaxResult(result);
		HashMap<String, Object> hashMap = ajaxResult.getResultMessage();
		return hashMap;
	}

	// employee(직원) 삭제
	// parameter -> employee_no,employee_id
	@Override
	public HashMap<String, Object> employeeDelete(HashMap<String, Object> param) {
		int result = 0;
		result = employeeDAO.employeeDelete(param);
		this.ajaxResult = new AjaxResult(result);
		HashMap<String, Object> hashMap = ajaxResult.getResultMessage();
		return hashMap;
	}

}
