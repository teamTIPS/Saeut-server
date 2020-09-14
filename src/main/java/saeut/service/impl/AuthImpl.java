package saeut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import saeut.dao.AuthDao;
import saeut.domain.Auth;
import saeut.service.facade.AuthFacade;

@Repository
@Service("authImpl")
@Transactional
public class AuthImpl implements AuthFacade{
	
	@Autowired
	private AuthDao authDao;

	@Override
	public List<Auth> getAllAuth() {
		// TODO Auto-generated method stub
		return authDao.getAllAuth();
	}

	@Override
	public List<Auth> getAuthByUserId(String id) {
		// TODO Auto-generated method stub
		return authDao.getAuthByUserId(id);
	}

	@Override
	public void insertAuth(Auth auth) {
		// TODO Auto-generated method stub
		authDao.insertAuth(auth);
	}

	@Override
	public void removeAuth(String id) {
		// TODO Auto-generated method stub
		authDao.removeAuth(id);
	}

	@Override
	public void modAuth(Auth auth) {
		// TODO Auto-generated method stub
		authDao.modAuth(auth);
		
	}

	@Override
	public int isDuplicated(String id) {
		// TODO Auto-generated method stub
		return authDao.isDuplicated(id);
	}


}
