package saeut.dao.mybatis.mapper;

import java.util.List;

import saeut.domain.Auth;

public interface AuthMapper {

	List<Auth> getAllAuth();
	
	List<Auth> getAuthByUserId(String id);
	
	void insertAuth(Auth auth);
	
	void removeAuth(String id);
	
	void modAuth(Auth auth);
	
	int isDuplicated(String id);
}
