package com.groupware.sun.login.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.sun.employee.dto.Employee;
import com.groupware.sun.login.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	@Override
	public HashMap<String, Object> login(HashMap<String, Object> param, HttpSession session) {
		Employee employee = loginDAO.login(param);
		HashMap<String, Object> hashMap;
		int result = 0;
		if (employee == null) {
			hashMap = resultData(result);
		} else {
			result = 1;
			session.setAttribute("myInfo", employee);
			hashMap = resultData(result);
		}
		return hashMap;
	}

	@Override
	public void logOut(HttpSession session) {
		loginDAO.logOut(session);

	}

	// 결과값 반환
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
