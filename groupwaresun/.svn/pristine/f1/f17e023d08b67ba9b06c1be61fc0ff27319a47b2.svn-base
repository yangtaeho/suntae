package com.groupware.sun.common.mapping;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.sun.login.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	private String folder = "login";

	@RequestMapping("/loginUI")
	public String login() {
		return folder + "/loginUI";
	}

	// 로그인
	// parameter -> emplyoee_id,employee_pw
	@ResponseBody
	@RequestMapping("/login_ok")
	public HashMap<String, Object> login_ok(@RequestParam HashMap<String, Object> param, HttpSession session) {
		HashMap<String, Object> hashMap = loginService.login(param, session);
		return hashMap;
	}

	// 로그아웃
	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		loginService.logOut(session);
		return folder + "/loginUI";
	}
}
