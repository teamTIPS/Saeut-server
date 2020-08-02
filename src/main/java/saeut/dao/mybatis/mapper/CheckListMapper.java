package saeut.dao.mybatis.mapper;

import java.util.List;

import saeut.domain.CheckList;

public interface CheckListMapper {

	// 모든 CheckList 가져오기
	List<CheckList> getAllCheckList();
		
	// userId로 CheckList 가져오기
	CheckList getCheckListByUserId(String userId);
		
	// CheckList 추가하기
	void insertCheckList(CheckList CheckList);
		
	// CheckList 수정하기
	void modCheckList(CheckList CheckList);
		
	// userId로 CheckList 삭제하기
	void removeCheckList(String userId);
}
