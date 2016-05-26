package com.groupware.sun.department.dto;

import java.io.Serializable;

public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	private int department_no;
	private String department_name;

	public Department() {
	}

	public Department(int department_no, String department_name) {
		super();
		this.department_no = department_no;
		this.department_name = department_name;
	}

	public int getDepartment_no() {
		return department_no;
	}

	public void setDepartment_no(int department_no) {
		this.department_no = department_no;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	@Override
	public String toString() {
		return "Department [department_no=" + department_no + ", department_name=" + department_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department_name == null) ? 0 : department_name.hashCode());
		result = prime * result + department_no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (department_name == null) {
			if (other.department_name != null)
				return false;
		} else if (!department_name.equals(other.department_name))
			return false;
		if (department_no != other.department_no)
			return false;
		return true;
	}

}
