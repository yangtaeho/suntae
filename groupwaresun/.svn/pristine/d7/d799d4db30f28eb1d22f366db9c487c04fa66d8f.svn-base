package com.groupware.sun.employee.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.sun.employee.dto.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SqlSessionFactory factory;

	private SqlSession getSqlSession() {
		return factory.openSession();
	}

	private void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}

	/*
	 * employee(직원) 등록(관리자가 등록) parameter ->
	 * role_no,employee_status_no,employee_name,employee_id,employee_pw,
	 * employee_hp,employee_email,department_no,team_no,position_no,employee_ip
	 * employee_activity_no
	 */
	@Override
	public int employeeRegist(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int employeeRegistResult = sqlSession.insert("employee.employeeRegist", param);
		closeSqlSession(sqlSession);
		return employeeRegistResult;
	}

	// employee(직원) 데이터 갯수
	// parameter -> 검색값 search_sel,search_txt
	@Override
	public int employeeCount(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int employeeCount = sqlSession.selectOne("employee.employeeCount", param);
		closeSqlSession(sqlSession);
		return employeeCount;
	}

	// employee(직원) 리스트 조회
	// parameter -> 검색값 search_sel,search_txt,startRow,endRow
	@Override
	public List<Employee> employeeGetList(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		List<Employee> employeeList = sqlSession.selectList("employee.employeeList", param);
		closeSqlSession(sqlSession);
		return employeeList;
	}

	// employee(직원) 상세 조회
	// parameter -> employee_no,employee_id
	@Override
	public Employee employeeDetail(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		Employee employee = sqlSession.selectOne("employee.employeeDetail", param);
		closeSqlSession(sqlSession);
		return employee;
	}

	// employee(직원) 수정
	// parameter -> employee_no,employee_id
	@Override
	public int employeeUpdate(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int employeeUpdateResult = sqlSession.update("employee.employeeUpdate", param);
		closeSqlSession(sqlSession);
		return employeeUpdateResult;
	}

	// employee(직원) 삭제
	// parameter -> employee_no,employee_id
	@Override
	public int employeeDelete(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int employeeDeleteResult = sqlSession.delete("employee.employeeDelete", param);
		closeSqlSession(sqlSession);
		return employeeDeleteResult;
	}

}
