package com.groupware.sun.role.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.sun.role.dto.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SqlSessionFactory factory;

	private SqlSession getSqlSession() {
		return factory.openSession();
	}

	private void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}

	// role(권한) 등록
	// parameter -> role_name
	@Override
	public int roleRegist(String role_name) {
		SqlSession sqlSession = getSqlSession();
		int roleRegistResult = sqlSession.insert("role.roleRegist", role_name);
		closeSqlSession(sqlSession);
		return roleRegistResult;
	}

	// role(권한) 데이터 갯수
	// parameter -> 검색값 search_sel,search_txt
	@Override
	public int roleCount(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int roleCount = sqlSession.selectOne("role.roleCount", param);
		closeSqlSession(sqlSession);
		return roleCount;
	}

	// role(권한) 리스트 조회
	// parameter -> 검색값 search_sel,search_txt,startRow,endRow
	@Override
	public List<Role> roleGetList(HashMap<String, Object> hashMap) {
		SqlSession sqlSession = getSqlSession();
		List<Role> roleList = sqlSession.selectList("role.roleList", hashMap);
		closeSqlSession(sqlSession);
		return roleList;
	}

	// role(권한) 상세 조회
	// parameter -> role_name
	@Override
	public Role roleDetail(String role_name) {
		SqlSession sqlSession = getSqlSession();
		Role role = sqlSession.selectOne("role.roleDetail", role_name);
		closeSqlSession(sqlSession);
		return role;
	}

	// role(권한) 수정
	// parameter -> role_no,role_name
	@Override
	public int roleUpdate(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int roleUpdateResult = sqlSession.update("role.roleUpdate", param);
		closeSqlSession(sqlSession);
		return roleUpdateResult;
	}

	// role(권한) 삭제
	// parameter -> role_no
	@Override
	public int roleDelete(int role_no) {
		SqlSession sqlSession = getSqlSession();
		int roleDeleteResult = sqlSession.delete("role.roleDelete", role_no);
		closeSqlSession(sqlSession);
		return roleDeleteResult;
	}

}
