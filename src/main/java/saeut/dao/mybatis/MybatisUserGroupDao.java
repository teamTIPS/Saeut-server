package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import saeut.dao.UserGroupDao;
import saeut.dao.mybatis.mapper.UserGroupMapper;
import saeut.domain.UserGroup;

@Repository
public class MybatisUserGroupDao implements UserGroupDao{

	@Autowired
	private UserGroupMapper userGroupMapper;

	@Override
	public List<UserGroup> getAllUserGroup() {
		// TODO Auto-generated method stub
		return userGroupMapper.getAllUserGroup();
	}

	@Override
	public List<UserGroup> getUserGroupByUserId(String userId) {
		// TODO Auto-generated method stub
		return userGroupMapper.getUserGroupByUserId(userId);
	}

	@Override
	public List<UserGroup> getUserGroupByType(int type) {
		// TODO Auto-generated method stub
		return userGroupMapper.getUserGroupByType(type);
	}

	@Override
	public List<UserGroup> getUserGroupByPost_id(int post_id) {
		// TODO Auto-generated method stub
		return userGroupMapper.getUserGroupByPost_id(post_id);
	}

	@Override
	public void insertUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		userGroupMapper.insertUserGroup(userGroup);
	}

	@Override
	public void modUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		userGroupMapper.modUserGroup(userGroup);
	}

	@Override
	public void removeUserGroup(String userID) {
		// TODO Auto-generated method stub
		userGroupMapper.removeUserGroup(userID);
	}
	

	
}
