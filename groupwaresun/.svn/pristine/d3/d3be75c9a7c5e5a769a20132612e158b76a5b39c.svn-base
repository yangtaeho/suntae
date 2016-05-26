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
import com.groupware.sun.employee_status.dto.Employee_status;
import com.groupware.sun.employee_status.service.Employee_statusService;

@Controller
public class Employee_statusController {

	@Autowired
	private Employee_statusService employee_statusService;

	private String folder = "employee_status";

	// employee_status(권한) 등록
	@ResponseBody
	@RequestMapping(value = "/employee_statusRegist", method = RequestMethod.POST)
	public HashMap<String, Object> employee_statusRegist(@RequestParam HashMap<String, Object> param) {
		String employee_status_name = String.valueOf(param.get("employee_status_name")).trim();
		HashMap<String, Object> hashMap = employee_statusService.employee_statusRegist(employee_status_name);
		return hashMap;
	}

	// employee_status(권한) 조회
	@RequestMapping("/employee_status")
	public String employee_status(Model model, @RequestParam HashMap<String, Object> param) {
		int totalCount = employee_statusService.employee_statusCount(param);
		param.put("totalCount", totalCount);
		param.put("pageUrl", "employee_status");
		Paging paging = new Paging();
		paging.initPage(param);
		List<Employee_status> employee_statusList = employee_statusService.employee_statusGetList(paging);
		model.addAttribute("paging", paging);
		model.addAttribute("employee_statusList", employee_statusList);
		return folder + "/employee_status";
	}

	// employee_status(권한) 수정
	@ResponseBody
	@RequestMapping(value = "/employee_statusUpdate", method = RequestMethod.POST)
	public HashMap<String, Object> employee_statusUpdate(@RequestParam HashMap<String, Object> param) {
		HashMap<String, Object> hashMap = employee_statusService.employee_statusUpdate(param);
		return hashMap;
	}

	// employee_status(권한) 삭제
	// 위엣것처럼 나중에 바꾸자.일단 예제로 남겨놓아야 하니깐
	@ResponseBody
	@RequestMapping(value = "/employee_statusDelete/{employee_status_no}", method = RequestMethod.POST)
	public HashMap<String, Object> employee_statusDelete(@PathVariable int employee_status_no) {
		HashMap<String, Object> hashMap = employee_statusService.employee_statusDelete(employee_status_no);
		return hashMap;
	}
}
