package com.groupware.sun.test;

import java.io.Serializable;

public class Test implements Serializable {

	private static final long serialVersionUID = 1L;
	private int test_no;
	private String test_name;

	public Test() {
	}

	public Test(int test_no, String test_name) {
		super();
		this.test_no = test_no;
		this.test_name = test_name;
	}

	public int getTest_no() {
		return test_no;
	}

	public void setTest_no(int test_no) {
		this.test_no = test_no;
	}

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	@Override
	public String toString() {
		return "Test [test_no=" + test_no + ", test_name=" + test_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + test_no;
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
		Test other = (Test) obj;
		if (test_no != other.test_no)
			return false;
		return true;
	}

}
