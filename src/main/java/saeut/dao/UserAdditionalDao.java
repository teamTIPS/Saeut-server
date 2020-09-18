package saeut.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.UserAdditional;

public interface UserAdditionalDao {

	// 모든 UserAdditional 가져오기
	List<UserAdditional> getAllUserAdditional() throws DataAccessException;
	
	// userId로 UserAdditional 가져오기
	UserAdditional getUserAdditionalByUserId(String userId) throws DataAccessException;
	
	// UserAdditional 추가하기
	void insertUserAdditional(UserAdditional UserAdditional) throws DataAccessException;
	
	// UserAdditional 수정하기
	void modUserAdditional(UserAdditional UserAdditional) throws DataAccessException;
	
	// userId로 UserAdditional 삭제하기
	void removeUserAdditional(String userId) throws DataAccessException;
	
	//닉네임 중복 체크 
	boolean isNickDuplicated(String nickname) throws DataAccessException;
}
