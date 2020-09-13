package saeut.dao.mybatis.mapper;

import java.util.List;

import saeut.domain.UserAdditional;

public interface UserAdditionalMapper {

	// 모든 UserAdditional 가져오기
	List<UserAdditional> getAllUserAdditional();
	
	// userId로 UserAdditional 가져오기
	UserAdditional getUserAdditionalByUserId(String userId);
	
	// UserAdditional 추가하기
	void insertUserAdditional(UserAdditional UserAdditional);
	
	// UserAdditional 수정하기
	void modUserAdditional(UserAdditional UserAdditional);
	
	// userId로 UserAdditional 삭제하기
	void removeUserAdditional(String userId);
	
}
