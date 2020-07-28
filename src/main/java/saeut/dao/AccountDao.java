package saeut.dao;

import org.springframework.dao.DataAccessException;

import saeut.domain.Account;

public interface AccountDao {

	// userId로 Account 가져오기
	Account getAccountByUserId(String id) throws DataAccessException;
		
}
