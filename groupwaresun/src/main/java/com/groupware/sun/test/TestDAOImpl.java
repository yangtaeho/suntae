package com.groupware.sun.test;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.sun.common.util.SideMenu;

@Repository
public class TestDAOImpl implements TestDAO {

	@Autowired
	private SqlSessionFactory factory;

	private SqlSession getSqlSession() {
		return this.factory.openSession();
	}

	private void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}

	@Override
	public List<Test> getTestList(HashMap<String, Object> hashMap) {
		SqlSession sqlSession = getSqlSession();
		List<Test> testList = sqlSession.selectList("test.testList", hashMap);
		closeSqlSession(sqlSession);
		return testList;
	}

	@Override
	public int testCount(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int testCount = sqlSession.selectOne("test.testCount", param);
		closeSqlSession(sqlSession);
		return testCount;
	}

	@Override
	public List<SideMenu> getSideMenuList() {
		SqlSession sqlSession = getSqlSession();
		List<SideMenu> sideMenuList = sqlSession.selectList("side_menu.side_menu_List");
		closeSqlSession(sqlSession);
		return sideMenuList;
	}

}
