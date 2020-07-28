package saeut.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import saeut.dao.AccountDao;
import saeut.dao.mybatis.mapper.AccountMapper;
import saeut.domain.Account;

@Repository
public class MybatisAccountDao implements AccountDao {

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public Account getAccountByUserId(String id) throws DataAccessException {
		return accountMapper.getAccountByUserId(id);
	}

	
}
