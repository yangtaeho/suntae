package com.groupware.sun.login.dao;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.sun.employee.dto.Employee;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SqlSessionFactory factory;

	private SqlSession getSqlSession() {
		return factory.openSession();
	}

	private void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}

	@Override
	public Employee login(HashMap<String, Object> param) {
		SqlSession sqlSesssion = getSqlSession();
		Employee employee = sqlSesssion.selectOne("login.employeeLogin", param);
		closeSqlSession(sqlSesssion);
		return employee;
	}

	@Override
	public void logOut(HttpSession session) {
		session.invalidate();
	}

}
