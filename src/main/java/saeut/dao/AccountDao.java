package saeut.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.Account;

public interface AccountDao {

	// userId로 Account 가져오기
	Account getAccountByUserId(String id) throws DataAccessException;
	
	// userId랑 password로 Account 가져오기
	Account getAccountByUserIdAndPassword(String id, String password);		
	
	// 모든 Account 가져오기
	List<Account> getAllAccount() throws DataAccessException;
	
	// Account 추가하기
	void insertAccount(Account account) throws DataAccessException;
		
	// userID로  Account로 수정하기
	void modAccount(Account account) throws DataAccessException;
		
	// userID로 Account 삭제하기
	void removeAccount(String userId) throws DataAccessException;
}
