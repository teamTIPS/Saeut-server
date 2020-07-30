package saeut.dao.mybatis.mapper;

import java.util.List;

import saeut.domain.Account;

public interface AccountMapper {

	// 모든 Account 가져오기
	List<Account> getAllAccount();
	
	// userId로 Account 가져오기
	Account getAccountByUserId(String userId);
	
	// Account 추가하기
	void insertAccount(Account account);
	
	// Account 수정하기
	void modAccount(Account account);
	
	// userID로 Account 삭제하기
	void removeAccount(String userId);
	
}
