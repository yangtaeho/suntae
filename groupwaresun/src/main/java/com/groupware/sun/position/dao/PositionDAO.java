package com.groupware.sun.position.dao;

import java.util.HashMap;
import java.util.List;

import com.groupware.sun.position.dto.Position;

public interface PositionDAO {

	public int positionRegist(String position_name);

	public int positionCount(HashMap<String, Object> param);

	public List<Position> positionGetList(HashMap<String, Object> hashMap);

	public Position positionDetail(String position_name);

	public int positionUpdate(HashMap<String, Object> param);

	public int positionDelete(int position_no);
}
