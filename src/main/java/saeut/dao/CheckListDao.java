package saeut.dao;

import java.util.List;

import saeut.domain.CheckList;

public interface CheckListDao {

	// 모든 CheckList 가져오기
	List<CheckList> getAllCheckList();
	
	// 집계 결과 상위 6위(??수정가능) 안에 드는 checklist 가져오기
	List<CheckList> getTop6CheckList();
	
}
