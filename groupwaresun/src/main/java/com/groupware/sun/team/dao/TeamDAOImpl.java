package com.groupware.sun.team.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.sun.team.dto.Team;

@Repository
public class TeamDAOImpl implements TeamDAO {

	@Autowired
	private SqlSessionFactory factory;

	private SqlSession getSqlSession() {
		return factory.openSession();
	}

	private void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}

	// team(팀) 등록
	// parameter -> team_name
	@Override
	public int teamRegist(String team_name) {
		SqlSession sqlSession = getSqlSession();
		int teamRegistResult = sqlSession.insert("team.teamRegist", team_name);
		closeSqlSession(sqlSession);
		return teamRegistResult;
	}

	// team(팀) 데이터 갯수
	// parameter -> 검색값 search_sel,search_txt
	@Override
	public int teamCount(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int teamCount = sqlSession.selectOne("team.teamCount", param);
		closeSqlSession(sqlSession);
		return teamCount;
	}

	// team(팀) 리스트 조회
	// parameter -> 검색값 search_sel,search_txt,startRow,endRow
	@Override
	public List<Team> teamGetList(HashMap<String, Object> hashMap) {
		SqlSession sqlSession = getSqlSession();
		List<Team> teamList = sqlSession.selectList("team.teamList", hashMap);
		closeSqlSession(sqlSession);
		return teamList;
	}

	// team(팀) 상세 조회
	// parameter -> team_name
	@Override
	public Team teamDetail(String team_name) {
		SqlSession sqlSession = getSqlSession();
		Team team = sqlSession.selectOne("team.teamDetail", team_name);
		closeSqlSession(sqlSession);
		return team;
	}

	// team(팀) 수정
	// parameter -> team_no,team_name
	@Override
	public int teamUpdate(HashMap<String, Object> param) {
		SqlSession sqlSession = getSqlSession();
		int teamUpdateResult = sqlSession.update("team.teamUpdate", param);
		closeSqlSession(sqlSession);
		return teamUpdateResult;
	}

	// team(팀) 삭제
	// parameter -> team_no
	@Override
	public int teamDelete(int team_no) {
		SqlSession sqlSession = getSqlSession();
		int teamDeleteResult = sqlSession.delete("team.teamDelete", team_no);
		closeSqlSession(sqlSession);
		return teamDeleteResult;
	}
}
