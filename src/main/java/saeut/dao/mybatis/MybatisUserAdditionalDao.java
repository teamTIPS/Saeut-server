package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import saeut.dao.UserAdditionalDao;
import saeut.dao.mybatis.mapper.UserAdditionalMapper;
import saeut.domain.UserAdditional;

@Repository
public class MybatisUserAdditionalDao implements UserAdditionalDao {

	@Autowired
	private UserAdditionalMapper UserAdditionalMapper;
	
	@Override
	public UserAdditional getUserAdditionalByUserId(String id) throws DataAccessException {
		return UserAdditionalMapper.getUserAdditionalByUserId(id);
	}
	
	@Override
	public List<UserAdditional> getAllUserAdditional() throws DataAccessException{
		return UserAdditionalMapper.getAllUserAdditional();
	};
	
	@Override
	public void insertUserAdditional(UserAdditional UserAdditional) {
		UserAdditionalMapper.insertUserAdditional(UserAdditional);
	};
		
    @Override
	public void modUserAdditional(UserAdditional UserAdditional) {
    	UserAdditionalMapper.modUserAdditional(UserAdditional);
    };
		
	@Override
	public void removeUserAdditional(String userId) {
		UserAdditionalMapper.removeUserAdditional(userId);
	};
	
	

	
}
