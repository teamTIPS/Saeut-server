package saeut.service.facade;

import java.util.List;

import saeut.domain.Auth;

public interface AuthFacade {

	List<Auth> getAllAuth();
	
	List<Auth> getAuthByUserId(String id);
	
	void insertAuth(Auth auth);
	
	void modAuth(Auth auth);
	
	void removeAuth(String id);
}
