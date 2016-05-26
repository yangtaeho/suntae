package com.groupware.sun.employee_status.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupware.sun.common.util.Paging;
import com.groupware.sun.employee_status.dao.Employee_statusDAO;
import com.groupware.sun.employee_status.dto.Employee_status;

@Transactional
@Service
public class Employee_statusServiceImpl implements Employee_statusService {

	@Autowired
	private Employee_statusDAO employee_statusDAO;

	// employee_status(직원상태) 등록
	// parameter -> employee_status_name
	@Override
	public HashMap<String, Object> employee_statusRegist(String employee_status_name) {
		int result = 0;
		// db에 동일한 직원상태명이 있을경우 등록 불가
		Employee_status employee_status = this.employee_statusDetail(employee_status_name);
		if (employee_status == null) {
			result = employee_statusDAO.employee_statusRegist(employee_status_name);
		} else {
			result = 0;
		}
		HashMap<String, Object> hashMap = resultData(result);
		return hashMap;
	}

	// employee_status(직원상태) 데이터 갯수
	// parameter -> 검색값 search_sel,search_txt
	@Override
	public int employee_statusCount(HashMap<String, Object> param) {
		return employee_statusDAO.employee_statusCount(param);
	}

	// employee_status(직원상태) 리스트 조회
	// parameter -> 검색값 search_sel,search_txt,startRow,endRow
	@Override
	public List<Employee_status> employee_statusGetList(Paging paging) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("startRow", paging.getStartRow());
		hashMap.put("endRow", paging.getEndRow());
		hashMap.put("search_sel", paging.getSearch_sel());
		hashMap.put("search_txt", paging.getSearch_txt());
		return employee_statusDAO.employee_statusGetList(hashMap);
	}

	// employee_status(직원상태) 상세 조회
	// parameter -> employee_status_name
	@Override
	public Employee_status employee_statusDetail(String employee_status_name) {
		return employee_statusDAO.employee_statusDetail(employee_status_name);
	}

	// employee_status(직원상태) 수정
	// parameter -> employee_status_no,employee_status_name
	@Override
	public HashMap<String, Object> employee_statusUpdate(HashMap<String, Object> param) {
		int result = 0;
		String employee_status_name = String.valueOf(param.get("employee_status_name")).trim();
		// db에 동일한 직원상태명이 있을경우 수정 불가
		Employee_status employee_status = this.employee_statusDetail(employee_status_name);
		if (employee_status == null) {
			result = employee_statusDAO.employee_statusUpdate(param);
		} else {
			result = 0;
		}
		HashMap<String, Object> hashMap = resultData(result);
		return hashMap;
	}

	// employee_status(직원상태) 삭제
	// parameter -> employee_status_no
	@Override
	public HashMap<String, Object> employee_statusDelete(int employee_status_no) {
		int result = 0;
		result = employee_statusDAO.employee_statusDelete(employee_status_no);
		HashMap<String, Object> hashMap = resultData(result);
		return hashMap;
	}

	// insert,update,delete 결과값 반환
	public HashMap<String, Object> resultData(int result) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if (result > 0) {
			hashMap.put("result", "success");
		} else if (result == 0) {
			hashMap.put("result", "fail");
		} else {
			hashMap.put("result", "error");
		}
		return hashMap;
	}
}
