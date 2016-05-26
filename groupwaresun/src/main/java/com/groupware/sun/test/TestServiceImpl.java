package com.groupware.sun.test;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.sun.common.util.PagingTest;
import com.groupware.sun.common.util.SideMenu;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDAO testDAO;

	@Override
	public List<Test> getTestList(PagingTest pagingTest) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("startRow", pagingTest.getStartRow());
		hashMap.put("endRow", pagingTest.getEndRow());
		hashMap.put("search_name", pagingTest.getSearch_name());
		hashMap.put("search_no", pagingTest.getSearch_no());
		hashMap.put("search_text", pagingTest.getSearch_text());
		return testDAO.getTestList(hashMap);
	}

	@Override
	public int testCount(HashMap<String, Object> param) {
		return testDAO.testCount(param);
	}

	@Override
	public List<SideMenu> getSideMenuList() {
		return testDAO.getSideMenuList();
	}

}
