package com.groupware.sun.role.dto;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	private int role_no;
	private String role_name;

	public Role() {
	}

	public Role(int role_no, String role_name) {
		super();
		this.role_no = role_no;
		this.role_name = role_name;
	}

	public int getRole_no() {
		return role_no;
	}

	public void setRole_no(int role_no) {
		this.role_no = role_no;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "Role [role_no=" + role_no + ", role_name=" + role_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role_name == null) ? 0 : role_name.hashCode());
		result = prime * result + role_no;
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
		Role other = (Role) obj;
		if (role_name == null) {
			if (other.role_name != null)
				return false;
		} else if (!role_name.equals(other.role_name))
			return false;
		if (role_no != other.role_no)
			return false;
		return true;
	}

}
