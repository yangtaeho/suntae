package com.groupware.sun.common.util;

import java.util.HashMap;

public class PagingTest {

	private int pageNumber;
	private int pageSize;
	private int totalCount;
	private String pageUrl;
	private int pageCount;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;
	private String parameter;
	private String search_name;
	private String search_no;
	private String search_text;
	private String page;

	public PagingTest() {
	}

	public void initPage(HashMap<String, Object> param) {
		this.search_name = (String) param.get("search_name");
		this.search_no = (String) param.get("seach_no");
		this.search_text = (String) param.get("search_text");
		this.search_name = search_name == null || search_name == "" ? "" : search_name;
		this.search_no = search_no == null || search_no == "" ? "" : search_no;
		this.search_text = search_text == null || search_text == "" ? "" : search_text;
		this.parameter = "";
		if (this.search_name != "") {
			this.parameter += "&search_name=" + search_name;
		}
		if (this.search_no != "") {
			this.parameter += "&search_no=" + search_no;
		}
		if (this.search_text != "") {
			this.parameter += "&search_text=" + search_text;
		}
		this.pageNumber = param.get("pageNumber") == null ? 1 : Integer.valueOf((String) param.get("pageNumber"));
		this.pageSize = param.get("pageSize") == null ? 15 : Integer.valueOf((String) param.get("pageSize"));
		this.totalCount = (int) (param.get("totalCount"));
		this.pageUrl = (String) param.get("pageUrl");
		this.pageCount = 10;
		this.startPage = (this.pageNumber - 1) / this.pageCount * this.pageCount + 1;
		this.endPage = this.startPage + this.pageCount - 1;
		this.totalPage = (int) Math.ceil((double) this.totalCount / this.pageSize);
		if (this.endPage >= this.totalPage) {
			this.endPage = this.totalPage;
		}
		this.startRow = (this.pageNumber - 1) * this.pageSize + 1;
		this.endRow = this.pageNumber * this.pageSize;
		getDisplayPage();
	}

	public String getSearch_name() {
		return search_name;
	}

	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}

	public String getSearch_no() {
		return search_no;
	}

	public void setSearch_no(String search_no) {
		this.search_no = search_no;
	}

	public String getSearch_text() {
		return search_text;
	}

	public void setSearch_text(String search_text) {
		this.search_text = search_text;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void getDisplayPage() {
		this.page = "";
		if (this.pageNumber < this.pageCount) {
			// 초반엔 아무것도 없다
			this.page += "<a href='#'>처음으로</a>";
			this.page += "<a href='#'>이전</a>";
		} else {
			this.page += "<a href=" + this.pageUrl + "?pageNumber=1&pageSize=15>처음으로</a>";
			this.page += "<a href=" + this.pageUrl + "?pageNumber=" + (this.startPage - 1);
			this.page += "&pageSize=15" + this.parameter + ">이전</a>";
		}
		for (int i = this.startPage; i <= this.endPage; i++) {
			this.page += "<a href=" + this.pageUrl + "?pageNumber=" + i + "&pageSize=15" + this.parameter + ">" + i
					+ "</a>";
		}
		if (this.startPage < this.totalPage / this.pageCount * this.pageCount + 1) {
			this.page += "<a href=" + this.pageUrl + "?pageNumber=" + (this.endPage + 1) + "&pageSize=15";
			this.page += this.parameter + ">다음</a>";
			this.page += "<a href=" + this.pageUrl + "?pageNumber=" + (this.totalPage);
			this.page += this.parameter + "&pageSize=15>끝</a>";
		} else {
			this.page += "<a href='#'>다음</a>";
			this.page += "<a href='#'>끝</a>";
		}
	}
}
