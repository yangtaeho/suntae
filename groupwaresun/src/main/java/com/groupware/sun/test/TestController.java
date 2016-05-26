package com.groupware.sun.test;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.sun.common.util.PagingTest;

@Controller
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping("/testList")
	public String testList(Model model, @RequestParam HashMap<String, Object> param) {
		int totalCount = testService.testCount(param);
		param.put("totalCount", totalCount);
		param.put("pageUrl", "testList");
		PagingTest pagingTest = new PagingTest();
		pagingTest.initPage(param);
		List<Test> testList = testService.getTestList(pagingTest);
		model.addAttribute("pagingTest", pagingTest);
		model.addAttribute("testList", testList);
		return "testList";
	}

}
