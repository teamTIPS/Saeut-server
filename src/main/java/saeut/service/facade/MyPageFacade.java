package saeut.service.facade;

import saeut.domain.Account;

public interface MyPageFacade {

	/////////////////////////////////////////////////////////////////////////
	/* Account */
	/////////////////////////////////////////////////////////////////////////
	Account getAccountByUserId(String id);

}