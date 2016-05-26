package com.groupware.sun.position.dto;

import java.io.Serializable;

public class Position implements Serializable {

	private static final long serialVersionUID = 1L;
	private int position_no;
	private String position_name;

	public Position() {

	}

	public Position(int position_no, String position_name) {
		super();
		this.position_no = position_no;
		this.position_name = position_name;
	}

	public int getPosition_no() {
		return position_no;
	}

	public void setPosition_no(int position_no) {
		this.position_no = position_no;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	@Override
	public String toString() {
		return "Position [position_no=" + position_no + ", position_name=" + position_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position_name == null) ? 0 : position_name.hashCode());
		result = prime * result + position_no;
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
		Position other = (Position) obj;
		if (position_name == null) {
			if (other.position_name != null)
				return false;
		} else if (!position_name.equals(other.position_name))
			return false;
		if (position_no != other.position_no)
			return false;
		return true;
	}

}
