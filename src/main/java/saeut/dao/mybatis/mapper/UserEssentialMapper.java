package saeut.dao.mybatis.mapper;

import java.util.List;

import saeut.domain.UserEssential;
import saeut.domain.LoginInfo;

public interface UserEssentialMapper {

	// 모든 UserEssential 가져오기
	List<UserEssential> getAllUserEssential();
	
	// userId랑 password로 UserEssential 가져오기
	UserEssential getUserEssentialByUserIdAndPassword(LoginInfo loginInfo);	
	
	// userID로 중복 검사하기
	boolean isIdDuplicated(String id);
	
	// userId로 UserEssential 가져오기
	UserEssential getUserEssentialByUserId(String userId);
	
	// userID로 NickName 가져오기
	String getNicknameByUserID(String userId);
	
	// UserEssential 추가하기
	void insertUserEssential(UserEssential UserEssential);
	
	// UserEssential 수정하기
	void modUserEssential(UserEssential UserEssential);
	
	// userID로 UserEssential 삭제하기
	void removeUserEssential(String userId);

}
