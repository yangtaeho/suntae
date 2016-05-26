package com.groupware.sun.common.mapping;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.sun.common.util.Paging;
import com.groupware.sun.department.dto.Department;
import com.groupware.sun.department.service.DepartmentService;
import com.groupware.sun.employee.dto.Employee;
import com.groupware.sun.employee.service.EmployeeService;
import com.groupware.sun.employee_status.dto.Employee_status;
import com.groupware.sun.employee_status.service.Employee_statusService;
import com.groupware.sun.position.dto.Position;
import com.groupware.sun.position.service.PositionService;
import com.groupware.sun.role.dto.Role;
import com.groupware.sun.role.service.RoleService;
import com.groupware.sun.team.dto.Team;
import com.groupware.sun.team.service.TeamService;

@Controller
public class EmployeeController {

	private String folder = "employee";

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private Employee_statusService employee_statusService;

	@RequestMapping("/employeeRegistUI")
	public ModelAndView emplyoeeRegistUI(ModelAndView mav) {

		// 권한리스트
		List<Role> roleList = roleService.roleGetList(new Paging());
		// 부서 리스트
		List<Department> departmentList = departmentService.departmentGetList(new Paging());
		// 팀 리스트
		List<Team> teamList = teamService.teamGetList(new Paging());
		// 직급 리스트
		List<Position> positionList = positionService.positionGetList(new Paging());
		// 직원상태 리스트
		List<Employee_status> employee_statusList = employee_statusService.employee_statusGetList(new Paging());

		mav.addObject("roleList", roleList);
		mav.addObject("departmentList", departmentList);
		mav.addObject("teamList", teamList);
		mav.addObject("positionList", positionList);
		mav.addObject("employee_statusList", employee_statusList);
		String folderName = folder + "/employeeRegistUI";
		mav.setViewName(folderName);
		return mav;
	}

	@RequestMapping("/employee")
	public String employee(Model model, @RequestParam HashMap<String, Object> param) {
		int totalCount = employeeService.employeeCount(param);
		param.put("totalCount", totalCount);
		param.put("pageUrl", "employee");
		Paging paging = new Paging();
		paging.initPage(param);
		List<Employee> employeeList = employeeService.employeeGetList(paging);
		model.addAttribute("paging", paging);
		model.addAttribute("employeeList", employeeList);
		return folder + "/employee";
	}

	@ResponseBody
	@RequestMapping("/employeeRegist")
	public HashMap<String, Object> employeeRegist(@RequestParam HashMap<String, Object> param) {
		HashMap<String, Object> hashMap = employeeService.employeeRegist(param);
		return hashMap;
	}

	@RequestMapping("/employeeUpdateUI")
	public ModelAndView employeeUpdateUI(ModelAndView mav, int employee_no, String employee_id) {
		String viewFolder = folder + "/employeeUpdateUI";
		// 권한리스트
		List<Role> roleList = roleService.roleGetList(new Paging());
		// 부서 리스트
		List<Department> departmentList = departmentService.departmentGetList(new Paging());
		// 팀 리스트
		List<Team> teamList = teamService.teamGetList(new Paging());
		// 직급 리스트
		List<Position> positionList = positionService.positionGetList(new Paging());
		// 직원상태 리스트
		List<Employee_status> employee_statusList = employee_statusService.employee_statusGetList(new Paging());
		Employee employee = employeeService.employeeDetail(employee_no, employee_id);
		mav.addObject("roleList", roleList);
		mav.addObject("departmentList", departmentList);
		mav.addObject("teamList", teamList);
		mav.addObject("positionList", positionList);
		mav.addObject("employee_statusList", employee_statusList);
		mav.addObject("employee", employee);
		mav.setViewName(viewFolder);
		return mav;
	}

	// employee(직원) 수정
	@ResponseBody
	@RequestMapping("/employeeUpdate")
	public HashMap<String, Object> employeeUpdate_ok(@RequestParam HashMap<String, Object> param) {
		HashMap<String, Object> hashMap = employeeService.employeeUpdate(param);
		return hashMap;
	}

	// employee(직원) 삭제
	@ResponseBody
	@RequestMapping("/employeeDelete")
	public HashMap<String, Object> roleDelete(@RequestParam HashMap<String, Object> param) {
		HashMap<String, Object> hashMap = employeeService.employeeDelete(param);
		return hashMap;
	}
}
