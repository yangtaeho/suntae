package com.groupware.sun.team.service;

import java.util.HashMap;
import java.util.List;

import com.groupware.sun.common.util.Paging;
import com.groupware.sun.team.dto.Team;

public interface TeamService {

	public HashMap<String, Object> teamRegist(String team_name);

	public int teamCount(HashMap<String, Object> param);

	public List<Team> teamGetList(Paging paging);

	public Team teamDetail(String team_name);

	public HashMap<String, Object> teamUpdate(HashMap<String, Object> param);

	public HashMap<String, Object> teamDelete(int team_no);
}
