package saeut.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.Auth;

public interface AuthDao {

	List<Auth> getAllAuth();
	
	List<Auth> getAuthByUserId(String id);
	
	void insertAuth(Auth auth);
	
	void modAuth(Auth auth);
	
	void removeAuth(String id);
}
