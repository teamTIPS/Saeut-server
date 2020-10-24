package saeut.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.UserGroup;

public interface UserGroupDao {

	// 모든 UserGroup 가져오기
	List<UserGroup> getAllUserGroup();
		
	// userId로 UserGroup 가져오기
	List<UserGroup> getUserGroupByUserId(String userId);
	
	// type으로 UserGroup 가져오기
	List<UserGroup> getUserGroupByType(int type);
		
	// post_id로 UserGroup 가져오기
	List<UserGroup> getUserGroupByPost_id(int post_id);
		
	// UserGroup 추가하기
	void insertUserGroup(UserGroup userGroup);
		
	// UserGroup 수정하기
	void modUserGroup(UserGroup userGroup);
		
	// userid로 UserGroup 삭제하기
	void removeUserGroup(String userID);
}
