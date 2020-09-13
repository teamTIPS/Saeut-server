package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import saeut.dao.AuthDao;
import saeut.dao.mybatis.mapper.AuthMapper;
import saeut.domain.Auth;

@Repository
public class MybatisAuthDao implements AuthDao{

	@Autowired
	private AuthMapper authMapper;

	@Override
	public List<Auth> getAllAuth() {
		return authMapper.getAllAuth();
	}

	@Override
	public List<Auth> getAuthByUserId(String id) {
		// TODO Auto-generated method stub
		return authMapper.getAuthByUserId(id);
	}

	@Override
	public void insertAuth(Auth auth) {
		// TODO Auto-generated method stub
		authMapper.insertAuth(auth);
	}

	@Override
	public void removeAuth(String id) {
		// TODO Auto-generated method stub
		authMapper.removeAuth(id);
	}

	@Override
	public void modAuth(Auth auth) {
		// TODO Auto-generated method stub
		authMapper.modAuth(auth);
	}
	

}
