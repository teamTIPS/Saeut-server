package saeut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import saeut.dao.AccountDao;
import saeut.domain.Account;
import saeut.service.facade.MyPageFacade;

@Repository
@Service("mypageImpl")
@Transactional
public class MyPageImpl implements MyPageFacade{

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Account getAccountByUserId(String id) {
		return accountDao.getAccountByUserId(id);
	}

	
}
