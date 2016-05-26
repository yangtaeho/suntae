package com.groupware.sun.position.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.sun.position.dto.Position;

@Repository
public class PositionDAOImpl implements PositionDAO {

	@Autowired
	private SqlSessionFactory factory;

	private SqlSession getSqlSession() {
		return factory.openSession();
	}

	private void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}

	// position(직급) 등록
	// parameter -> position_name
	@Override
	public int positionRegist(String position_name) {
		SqlSession sqlSession = getSqlSession();
		int positionRegistResult = sqlSession.insert("position.positionRegist", position_name);
		closeSqlSession(sqlSession);
		return positionRegistResult;
	}

	// position(직급) 데이터 갯수
	// parameter -> 검색값 search_sel,search_txt
	@Override
	public int positionCount(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int positionCount = sqlSession.selectOne("position.positionCount", param);
		closeSqlSession(sqlSession);
		return positionCount;
	}

	// position(직급) 리스트 조회
	// parameter -> 검색값 search_sel,search_txt,startRow,endRow
	@Override
	public List<Position> positionGetList(HashMap<String, Object> hashMap) {
		SqlSession sqlSession = getSqlSession();
		List<Position> positionList = sqlSession.selectList("position.positionList", hashMap);
		closeSqlSession(sqlSession);
		return positionList;
	}

	// position(직급) 상세 조회
	// parameter -> position_name
	@Override
	public Position positionDetail(String position_name) {
		SqlSession sqlSession = getSqlSession();
		Position position = sqlSession.selectOne("position.positionDetail", position_name);
		closeSqlSession(sqlSession);
		return position;
	}

	// position(직급) 수정
	// parameter -> position_no,position_name
	@Override
	public int positionUpdate(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int positionUpdateResult = sqlSession.update("position.positionUpdate", param);
		closeSqlSession(sqlSession);
		return positionUpdateResult;
	}

	// position(직급) 삭제
	// parameter -> position_no
	@Override
	public int positionDelete(int position_no) {
		SqlSession sqlSession = getSqlSession();
		int positionDeleteResult = sqlSession.delete("position.positionDelete", position_no);
		closeSqlSession(sqlSession);
		return positionDeleteResult;
	}
}
