package com.groupware.sun.employee_status.dto;

import java.io.Serializable;

public class Employee_status implements Serializable {

	private static final long serialVersionUID = 1L;
	private int employee_status_no;
	private String employee_status_name;

	public Employee_status() {
	}

	public Employee_status(int employee_status_no, String employee_status_name) {
		super();
		this.employee_status_no = employee_status_no;
		this.employee_status_name = employee_status_name;
	}

	public int getEmployee_status_no() {
		return employee_status_no;
	}

	public void setEmployee_status_no(int employee_status_no) {
		this.employee_status_no = employee_status_no;
	}

	public String getEmployee_status_name() {
		return employee_status_name;
	}

	public void setEmployee_status_name(String employee_status_name) {
		this.employee_status_name = employee_status_name;
	}

	@Override
	public String toString() {
		return "Employee_status [employee_status_no=" + employee_status_no + ", employee_status_name="
				+ employee_status_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee_status_name == null) ? 0 : employee_status_name.hashCode());
		result = prime * result + employee_status_no;
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
		Employee_status other = (Employee_status) obj;
		if (employee_status_name == null) {
			if (other.employee_status_name != null)
				return false;
		} else if (!employee_status_name.equals(other.employee_status_name))
			return false;
		if (employee_status_no != other.employee_status_no)
			return false;
		return true;
	}

}
