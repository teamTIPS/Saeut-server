package saeut.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.Account;
import saeut.domain.LoginInfo;

public interface AccountDao {

	// userId로 Account 가져오기
	Account getAccountByUserId(String id) throws DataAccessException;
	
	// userId랑 password로 Account 가져오기
//	Account getAccountByUserIdAndPassword(Account account);		
	Account getAccountByUserIdAndPassword(LoginInfo loginInfo);		
	
	// 모든 Account 가져오기
	List<Account> getAllAccount() throws DataAccessException;
	
	// userID로 Nickname 가져오기
	String getNicknameByUserID(String id) throws DataAccessException;
	
	// Account 추가하기
	void insertAccount(Account account) throws DataAccessException;
		
	// userID로  Account로 수정하기
	void modAccount(Account account) throws DataAccessException;
		
	// userID로 Account 삭제하기
	void removeAccount(String userId) throws DataAccessException;
}
