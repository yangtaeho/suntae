package com.groupware.sun.position.service;

import java.util.HashMap;
import java.util.List;

import com.groupware.sun.common.util.Paging;
import com.groupware.sun.position.dto.Position;

public interface PositionService {

	public HashMap<String, Object> positionRegist(String position_name);

	public int positionCount(HashMap<String, Object> param);

	public List<Position> positionGetList(Paging paging);

	public Position positionDetail(String position_name);

	public HashMap<String, Object> positionUpdate(HashMap<String, Object> param);

	public HashMap<String, Object> positionDelete(int position_no);
}
