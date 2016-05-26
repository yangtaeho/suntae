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
import com.groupware.sun.department.dto.Department;
import com.groupware.sun.department.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private String folder = "department";

	// department(권한) 등록
	@ResponseBody
	@RequestMapping(value = "/departmentRegist", method = RequestMethod.POST)
	public HashMap<String, Object> departmentRegist(@RequestParam HashMap<String, Object> param) {
		String department_name = String.valueOf(param.get("department_name")).trim();
		HashMap<String, Object> hashMap = departmentService.departmentRegist(department_name);
		return hashMap;
	}

	// department(권한) 조회
	@RequestMapping("/department")
	public String department(Model model, @RequestParam HashMap<String, Object> param) {
		int totalCount = departmentService.departmentCount(param);
		param.put("totalCount", totalCount);
		param.put("pageUrl", "department");
		Paging paging = new Paging();
		paging.initPage(param);
		List<Department> departmentList = departmentService.departmentGetList(paging);
		model.addAttribute("paging", paging);
		model.addAttribute("departmentList", departmentList);
		return folder + "/department";
	}

	// department(권한) 수정
	@ResponseBody
	@RequestMapping(value = "/departmentUpdate", method = RequestMethod.POST)
	public HashMap<String, Object> departmentUpdate(@RequestParam HashMap<String, Object> param) {
		HashMap<String, Object> hashMap = departmentService.departmentUpdate(param);
		return hashMap;
	}

	// department(권한) 삭제
	// 위엣것처럼 나중에 바꾸자.일단 예제로 남겨놓아야 하니깐
	@ResponseBody
	@RequestMapping(value = "/departmentDelete/{department_no}", method = RequestMethod.POST)
	public HashMap<String, Object> departmentDelete(@PathVariable int department_no) {
		HashMap<String, Object> hashMap = departmentService.departmentDelete(department_no);
		return hashMap;
	}
}
