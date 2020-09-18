package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import saeut.dao.UserEssentialDao;
import saeut.dao.mybatis.mapper.UserEssentialMapper;
import saeut.domain.UserEssential;
import saeut.domain.LoginInfo;

@Repository
public class MybatisUserEssentialDao implements UserEssentialDao {

	@Autowired
	private UserEssentialMapper UserEssentialMapper;
	
	@Override
	public UserEssential getUserEssentialByUserId(String id) throws DataAccessException {
		return UserEssentialMapper.getUserEssentialByUserId(id);
	}
	
//	@Override
//	public UserEssential getUserEssentialByUserIdAndPassword(UserEssential UserEssential) {
//		return UserEssentialMapper.getUserEssentialByUserIdAndPassword(UserEssential);
//	};
	
	@Override
	public boolean isIdDuplicated(String id) {
		return UserEssentialMapper.isIdDuplicated(id);
	}
	
	@Override
	public UserEssential getUserEssentialByUserIdAndPassword(LoginInfo loginInfo) {
		return UserEssentialMapper.getUserEssentialByUserIdAndPassword(loginInfo);
	};
	
	@Override
	public List<UserEssential> getAllUserEssential() throws DataAccessException{
		return UserEssentialMapper.getAllUserEssential();
	};
	
	@Override
	public void insertUserEssential(UserEssential UserEssential) {
		UserEssentialMapper.insertUserEssential(UserEssential);
	};
		
    @Override
	public void modUserEssential(UserEssential UserEssential) {
    	UserEssentialMapper.modUserEssential(UserEssential);
    };
		
	@Override
	public void removeUserEssential(String userId) {
		UserEssentialMapper.removeUserEssential(userId);
	}

	@Override
	public String getNicknameByUserID(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return UserEssentialMapper.getNicknameByUserID(userId);
	}
		
}
