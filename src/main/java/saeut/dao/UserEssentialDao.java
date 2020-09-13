package saeut.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.UserEssential;
import saeut.domain.LoginInfo;

public interface UserEssentialDao {

	// userId로UserEssential 가져오기
	UserEssential getUserEssentialByUserId(String id) throws DataAccessException;
	
	// userId랑 password로UserEssential 가져오기
//	UserEssential getUserEssentialByUserIdAndPassword(UserEssentialUserEssential);		
	UserEssential getUserEssentialByUserIdAndPassword(LoginInfo loginInfo);		
	
	// userID로 중복 체크하기
	int isDuplicated(LoginInfo loginInfo);
	
	// 모든UserEssential 가져오기
	List<UserEssential> getAllUserEssential() throws DataAccessException;
	
	// userID로 Nickname 가져오기
	String getNicknameByUserID(String id) throws DataAccessException;
	
	//UserEssential 추가하기
	void insertUserEssential(UserEssential userEssential) throws DataAccessException;
		
	// userID로 UserEssential로 수정하기
	void modUserEssential(UserEssential userEssential) throws DataAccessException;
		
	// userID로UserEssential 삭제하기
	void removeUserEssential(String userId) throws DataAccessException;
}
