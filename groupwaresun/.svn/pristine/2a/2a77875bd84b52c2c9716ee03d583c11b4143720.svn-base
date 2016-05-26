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
import com.groupware.sun.role.dto.Role;
import com.groupware.sun.role.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	private String folder = "role";

	// role(권한) 등록
	@ResponseBody
	@RequestMapping(value = "/roleRegist", method = RequestMethod.POST)
	public HashMap<String, Object> roleRegist(@RequestParam HashMap<String, Object> param) {
		String role_name = String.valueOf(param.get("role_name")).trim();
		HashMap<String, Object> hashMap = roleService.roleRegist(role_name);
		return hashMap;
	}

	// role(권한) 조회
	@RequestMapping("/role")
	public String role(Model model, @RequestParam HashMap<String, Object> param) {
		int totalCount = roleService.roleCount(param);
		param.put("totalCount", totalCount);
		param.put("pageUrl", "role");
		Paging paging = new Paging();
		paging.initPage(param);
		List<Role> roleList = roleService.roleGetList(paging);
		model.addAttribute("paging", paging);
		model.addAttribute("roleList", roleList);
		return folder + "/role";
	}

	// role(권한) 수정
	@ResponseBody
	@RequestMapping(value = "/roleUpdate", method = RequestMethod.POST)
	public HashMap<String, Object> roleUpdate(@RequestParam HashMap<String, Object> param) {
		HashMap<String, Object> hashMap = roleService.roleUpdate(param);
		return hashMap;
	}

	// role(권한) 삭제
	// 위엣것처럼 나중에 바꾸자.일단 예제로 남겨놓아야 하니깐
	@ResponseBody
	@RequestMapping(value = "/roleDelete/{role_no}", method = RequestMethod.POST)
	public HashMap<String, Object> roleDelete(@PathVariable int role_no) {
		HashMap<String, Object> hashMap = roleService.roleDelete(role_no);
		return hashMap;
	}
}
