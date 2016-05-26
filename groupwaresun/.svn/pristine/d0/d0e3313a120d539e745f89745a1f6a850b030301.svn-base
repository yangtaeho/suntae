package com.groupware.sun.department.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.sun.department.dto.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	private SqlSessionFactory factory;

	private SqlSession getSqlSession() {
		return factory.openSession();
	}

	private void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}

	// department(부서) 등록
	// parameter -> department_name
	@Override
	public int departmentRegist(String department_name) {
		SqlSession sqlSession = getSqlSession();
		int departmentRegistResult = sqlSession.insert("department.departmentRegist", department_name);
		closeSqlSession(sqlSession);
		return departmentRegistResult;
	}

	// department(부서) 데이터 갯수
	// parameter -> 검색값 search_sel,search_txt
	@Override
	public int departmentCount(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int departmentCount = sqlSession.selectOne("department.departmentCount", param);
		closeSqlSession(sqlSession);
		return departmentCount;
	}

	// department(부서) 리스트 조회
	// parameter -> 검색값 search_sel,search_txt,startRow,endRow
	@Override
	public List<Department> departmentGetList(HashMap<String, Object> hashMap) {
		SqlSession sqlSession = getSqlSession();
		List<Department> departmentList = sqlSession.selectList("department.departmentList", hashMap);
		closeSqlSession(sqlSession);
		return departmentList;
	}

	// department(부서) 상세 조회
	// parameter -> department_name
	@Override
	public Department departmentDetail(String department_name) {
		SqlSession sqlSession = getSqlSession();
		Department department = sqlSession.selectOne("department.departmentDetail", department_name);
		closeSqlSession(sqlSession);
		return department;
	}

	// department(부서) 수정
	// parameter -> department_no,department_name
	@Override
	public int departmentUpdate(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int departmentUpdateResult = sqlSession.update("department.departmentUpdate", param);
		closeSqlSession(sqlSession);
		return departmentUpdateResult;
	}

	// department(부서) 삭제
	// parameter -> department_no
	@Override
	public int departmentDelete(int department_no) {
		SqlSession sqlSession = getSqlSession();
		int departmentDeleteResult = sqlSession.delete("department.departmentDelete", department_no);
		closeSqlSession(sqlSession);
		return departmentDeleteResult;
	}
}
