package com.groupware.sun.common.util;

import java.util.HashMap;

public class AjaxResult {

	private int result;
	private HashMap<String, Object> resultMessage;

	public AjaxResult() {
	}

	public AjaxResult(int result) {
		super();
		this.result = result;
		calculResultMessage();
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public HashMap<String, Object> getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(HashMap<String, Object> resultMessage) {
		this.resultMessage = resultMessage;
	}

	// insert,delete,update 값에 따라 반환값 담는다
	private void calculResultMessage() {
		this.resultMessage = new HashMap<String, Object>();
		if (this.result > 0) {
			this.resultMessage.put("result", "success");
		} else if (this.result == 0) {
			this.resultMessage.put("result", "fail");
		} else {
			this.resultMessage.put("result", "error");
		}
	}

	@Override
	public String toString() {
		return "AjaxResult [result=" + result + ", resultMessage=" + resultMessage + "]";
	}

}
