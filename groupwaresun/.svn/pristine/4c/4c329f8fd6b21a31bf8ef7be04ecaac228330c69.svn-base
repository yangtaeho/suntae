package com.groupware.sun.employee.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.groupware.sun.common.mapping.PositionController;
import com.groupware.sun.department.dto.Department;
import com.groupware.sun.employee_status.dto.Employee_status;
import com.groupware.sun.role.dto.Role;
import com.groupware.sun.team.dto.Team;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private int employee_no;
	private String employee_name;
	private String employee_id;
	private String employee_pw;
	private String employee_hp;
	private String employee_email;
	private String employee_ip;
	private int employee_activity_no;
	private Date employee_regist_date;
	private Role role;
	private Department department;
	private Team team;
	// 왜 이것만 컬렉션타입으로 해야 담기지? 추후 알아보자.
	private List<PositionController> position;
	private Employee_status employee_status;

	public Employee() {
	}

	public int getEmployee_no() {
		return employee_no;
	}

	public void setEmployee_no(int employee_no) {
		this.employee_no = employee_no;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_pw() {
		return employee_pw;
	}

	public void setEmployee_pw(String employee_pw) {
		this.employee_pw = employee_pw;
	}

	public String getEmployee_hp() {
		return employee_hp;
	}

	public void setEmployee_hp(String employee_hp) {
		this.employee_hp = employee_hp;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	public String getEmployee_ip() {
		return employee_ip;
	}

	public void setEmployee_ip(String employee_ip) {
		this.employee_ip = employee_ip;
	}

	public int getEmployee_activity_no() {
		return employee_activity_no;
	}

	public void setEmployee_activity_no(int employee_activity_no) {
		this.employee_activity_no = employee_activity_no;
	}

	public Date getEmployee_regist_date() {
		return employee_regist_date;
	}

	public void setEmployee_regist_date(Date employee_regist_date) {
		this.employee_regist_date = employee_regist_date;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<PositionController> getPosition() {
		return position;
	}

	public void setPosition(List<PositionController> position) {
		this.position = position;
	}

	public Employee_status getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(Employee_status employee_status) {
		this.employee_status = employee_status;
	}

}
