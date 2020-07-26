package saeut.dao.mybatis.mapper;

import saeut.domain.Account;

public interface AccountMapper {

	// userId로 Account 가져오기
	Account getAccountByUserId(String userId);
	
	
}
