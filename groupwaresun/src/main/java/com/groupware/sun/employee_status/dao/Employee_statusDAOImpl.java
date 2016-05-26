package com.groupware.sun.employee_status.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.sun.employee_status.dto.Employee_status;

@Repository
public class Employee_statusDAOImpl implements Employee_statusDAO {

	@Autowired
	private SqlSessionFactory factory;

	private SqlSession getSqlSession() {
		return factory.openSession();
	}

	private void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}

	// employee_status(직원상태) 등록
	// parameter -> employee_status_name
	@Override
	public int employee_statusRegist(String employee_status_name) {
		SqlSession sqlSession = getSqlSession();
		int employee_statusRegistResult = sqlSession.insert("employee_status.employee_statusRegist",
				employee_status_name);
		closeSqlSession(sqlSession);
		return employee_statusRegistResult;
	}

	// employee_status(직원상태) 데이터 갯수
	// parameter -> 검색값 search_sel,search_txt
	@Override
	public int employee_statusCount(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int employee_statusCount = sqlSession.selectOne("employee_status.employee_statusCount", param);
		closeSqlSession(sqlSession);
		return employee_statusCount;
	}

	// employee_status(직원상태) 리스트 조회
	// parameter -> 검색값 search_sel,search_txt,startRow,endRow
	@Override
	public List<Employee_status> employee_statusGetList(HashMap<String, Object> hashMap) {
		SqlSession sqlSession = getSqlSession();
		List<Employee_status> employee_statusList = sqlSession.selectList("employee_status.employee_statusList",
				hashMap);
		closeSqlSession(sqlSession);
		return employee_statusList;
	}

	// employee_status(직원상태) 상세 조회
	// parameter -> employee_status_name
	@Override
	public Employee_status employee_statusDetail(String employee_status_name) {
		SqlSession sqlSession = getSqlSession();
		Employee_status employee_status = sqlSession.selectOne("employee_status.employee_statusDetail",
				employee_status_name);
		closeSqlSession(sqlSession);
		return employee_status;
	}

	// employee_status(직원상태) 수정
	// parameter -> employee_status_no,employee_status_name
	@Override
	public int employee_statusUpdate(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int employee_statusUpdateResult = sqlSession.update("employee_status.employee_statusUpdate", param);
		closeSqlSession(sqlSession);
		return employee_statusUpdateResult;
	}

	// employee_status(직원상태) 삭제
	// parameter -> employee_status_no
	@Override
	public int employee_statusDelete(int employee_status_no) {
		SqlSession sqlSession = getSqlSession();
		int employee_statusDeleteResult = sqlSession.delete("employee_status.employee_statusDelete",
				employee_status_no);
		closeSqlSession(sqlSession);
		return employee_statusDeleteResult;
	}
}
