package com.groupware.sun.common.mapping;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.sun.common.util.Paging;
import com.groupware.sun.team.dto.Team;
import com.groupware.sun.team.service.TeamService;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamService;

	private String folder = "team";

	// team(팀) 등록
	@ResponseBody
	@RequestMapping(value = "/teamRegist", method = RequestMethod.POST)
	public HashMap<String, Object> teamRegist(@RequestParam HashMap<String, Object> param) {
		String team_name = String.valueOf(param.get("team_name")).trim();
		HashMap<String, Object> hashMap = teamService.teamRegist(team_name);
		return hashMap;
	}

	// team(팀) 조회
	@RequestMapping("/team")
	public String team(Model model, @RequestParam HashMap<String, Object> param) {
		int totalCount = teamService.teamCount(param);
		param.put("totalCount", totalCount);
		param.put("pageUrl", "team");
		Paging paging = new Paging();
		paging.initPage(param);
		List<Team> teamList = teamService.teamGetList(paging);
		model.addAttribute("paging", paging);
		model.addAttribute("teamList", teamList);
		return folder + "/team";
	}

	// team(팀) 수정
	@ResponseBody
	@RequestMapping(value = "/teamUpdate", method = RequestMethod.POST)
	public HashMap<String, Object> teamUpdate(@RequestParam HashMap<String, Object> param) {
		HashMap<String, Object> hashMap = teamService.teamUpdate(param);
		return hashMap;
	}

	// team(팀) 삭제
	// 위엣것처럼 나중에 바꾸자.일단 예제로 남겨놓아야 하니깐
	@ResponseBody
	@RequestMapping(value = "/teamDelete/{team_no}", method = RequestMethod.POST)
	public HashMap<String, Object> teamDelete(@PathVariable int team_no) {
		HashMap<String, Object> hashMap = teamService.teamDelete(team_no);
		return hashMap;
	}
}
