package com.groupware.sun.position.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupware.sun.common.util.AjaxResult;
import com.groupware.sun.common.util.Paging;
import com.groupware.sun.position.dao.PositionDAO;
import com.groupware.sun.position.dto.Position;

@Transactional
@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionDAO positionDAO;

	// ajax 결과값 Class
	private AjaxResult ajaxResult;

	// position(직급) 등록
	// parameter -> position_name
	@Override
	public HashMap<String, Object> positionRegist(String position_name) {
		int result = 0;
		// db에 동일한 직급명이 있을경우 등록 불가
		Position position = this.positionDetail(position_name);
		if (position == null) {
			result = positionDAO.positionRegist(position_name);
		} else {
			result = 0;
		}
		this.ajaxResult = new AjaxResult(result);
		HashMap<String, Object> hashMap = ajaxResult.getResultMessage();
		return hashMap;
	}

	// position(직급) 데이터 갯수
	// parameter -> 검색값 search_sel,search_txt
	@Override
	public int positionCount(HashMap<String, Object> param) {
		return positionDAO.positionCount(param);
	}

	// position(직급) 리스트 조회
	// parameter -> 검색값 search_sel,search_txt,startRow,endRow
	@Override
	public List<Position> positionGetList(Paging paging) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("startRow", paging.getStartRow());
		hashMap.put("endRow", paging.getEndRow());
		hashMap.put("search_sel", paging.getSearch_sel());
		hashMap.put("search_txt", paging.getSearch_txt());
		return positionDAO.positionGetList(hashMap);
	}

	// position(직급) 상세 조회
	// parameter -> position_name
	@Override
	public Position positionDetail(String position_name) {
		return positionDAO.positionDetail(position_name);
	}

	// position(직급) 수정
	// parameter -> position_no,position_name
	@Override
	public HashMap<String, Object> positionUpdate(HashMap<String, Object> param) {
		int result = 0;
		String position_name = String.valueOf(param.get("position_name")).trim();
		// db에 동일한 직급명이 있을경우 수정 불가
		Position position = this.positionDetail(position_name);
		if (position == null) {
			result = positionDAO.positionUpdate(param);
		} else {
			result = 0;
		}
		this.ajaxResult = new AjaxResult(result);
		HashMap<String, Object> hashMap = ajaxResult.getResultMessage();
		return hashMap;
	}

	// position(직급) 삭제
	// parameter -> position_no
	@Override
	public HashMap<String, Object> positionDelete(int position_no) {
		int result = 0;
		result = positionDAO.positionDelete(position_no);
		this.ajaxResult = new AjaxResult(result);
		HashMap<String, Object> hashMap = ajaxResult.getResultMessage();
		return hashMap;
	}

}
