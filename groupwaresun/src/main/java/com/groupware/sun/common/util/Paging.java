package com.groupware.sun.common.util;

import java.util.HashMap;

public class Paging {
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
	private String search_sel;
	private String search_txt;
	private String searchInfo;
	private String page;

	public Paging() {
	}

	public void initPage(HashMap<String, Object> param) {
		setSearch_sel((String) param.get("search_sel"));
		setSearch_txt((String) param.get("search_txt"));
		setSearchInfo();
		calculPageNumber(param.get("pageNumber"));
		calculPageSize(param.get("pageSize"));
		setTotalCount((int) param.get("totalCount"));
		setPageUrl((String) param.get("pageUrl"));
		setPageCount(10);
		calculStartPage();
		calculEndPage();
		calculTotalPage();
		calculStartRow();
		calculEndRow();
		getDisplayPage();
	}

	public String getSearch_sel() {
		return search_sel;
	}

	public void setSearch_sel(String search_sel) {
		this.search_sel = search_sel;
	}

	public String getSearch_txt() {
		return search_txt;
	}

	public void setSearch_txt(String search_txt) {
		this.search_txt = search_txt;
	}

	public String getSearchInfo() {
		return searchInfo;
	}

	private void setSearchInfo() {
		if (this.search_sel != null && this.search_txt != null) {
			this.searchInfo = "&search_sel=" + this.search_sel + "&search_txt=" + this.search_txt;
		} else {
			this.searchInfo = "";
		}
	}

	public void setSearchInfo(String searchInfo) {
		this.searchInfo = searchInfo;
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

	private void calculEndRow() {
		this.endRow = this.pageNumber * this.pageSize;
	}

	private void calculStartRow() {
		this.startRow = (this.pageNumber - 1) * this.pageSize + 1;

	}

	private void calculTotalPage() {
		this.totalPage = (int) Math.ceil((double) this.totalCount / this.pageSize);
		if (this.endPage >= this.totalPage) {
			this.endPage = this.totalPage;
		}

	}

	private void calculEndPage() {
		this.endPage = this.startPage + this.pageCount - 1;

	}

	private void calculStartPage() {
		this.startPage = (this.pageNumber - 1) / this.pageCount * this.pageCount + 1;

	}

	private void calculPageNumber(Object pageNumber) {
		this.pageNumber = pageNumber == null ? 1 : Integer.valueOf((String) pageNumber);
	}

	private void calculPageSize(Object pageSize) {
		this.pageSize = pageSize == null ? 15 : Integer.valueOf((String) pageSize);
	}

	private int calculPageStatus() {
		return totalPage / pageCount * pageCount + 1;
	}

	public void getDisplayPage() {
		this.page = "<nav class='paging-number text-center'>";
		this.page += "<ul class='pagination'>";

		if (this.pageNumber <= this.pageCount) {
			this.page += "<li class='disabled'><a href='#' aria-label='First'>";
			this.page += "<span aria-hidden='true'>&laquo;</span></a></li>";
			this.page += "<li class='disabled'><a href='#' aria-label='Previous'>";
			this.page += "<span aria-hidden='true'>&lsaquo;</span></a></li>";
		} else {
			this.page += "<li><a href=" + this.pageUrl + "?pageNumber=1&pageSize=15";
			this.page += getSearchInfo() + " " + "aria-label='First'>";
			this.page += "<span aria-hidden='true'>&laquo;</span></a></li>";
			this.page += "<li><a href=" + this.pageUrl + "?pageNumber=" + (this.startPage - 1);
			this.page += "&pageSize=" + this.pageSize + getSearchInfo() + " " + "aria-label='Previous'>";
			this.page += "<span aria-hidden='true'>&lsaquo;</span></a></li>";
		}
		for (int i = this.startPage; i <= this.endPage; i++) {
			if (this.pageNumber == i) {
				this.page += "<li class='active'>";
			} else {
				this.page += "<li>";
			}
			this.page += "<a href=" + this.pageUrl + "?pageNumber=" + i;
			this.page += "&pageSize=" + this.pageSize + getSearchInfo() + "> " + i + "</a></li>";
		}
		if (this.startPage < calculPageStatus()) {
			this.page += "<li><a href=" + this.pageUrl + "?pageNumber=" + (this.endPage + 1);
			this.page += "&pageSize=" + this.pageSize + getSearchInfo() + " " + "aria-label=Next>";
			this.page += "<span aria-hidden='true'>&rsaquo;</span></a></li>";
			this.page += "<li><a href=" + this.pageUrl + "?pageNumber=" + this.totalPage + "&pageSize=" + this.pageSize;
			this.page += getSearchInfo() + " " + "aria-label='End'>";
			this.page += "<span aria-hidden='true'>&raquo;</span></a></li>";
		} else {
			this.page += "<li class='disabled'><a href='#' aria-label='Next'>";
			this.page += "<span aria-hidden='true'>&rsaquo;</span></a></li>";
			this.page += "<li class='disabled'><a href='#' aria-label='End'>";
			this.page += "<span aria-hidden='true'>&raquo;</span></a></li>";
		}
		this.page += "</ul></nav>";
	}

	@Override
	public String toString() {
		return "Paging [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", pageUrl=" + pageUrl + ", pageCount=" + pageCount + ", totalPage=" + totalPage + ", startPage="
				+ startPage + ", endPage=" + endPage + ", startRow=" + startRow + ", endRow=" + endRow + ", parameter="
				+ parameter + ", search_sel=" + search_sel + ", search_txt=" + search_txt + ", searchInfo=" + searchInfo
				+ "]";
	}

}
