package saeut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import saeut.dao.UserEssentialDao;
import saeut.dao.UserAdditionalDao;
import saeut.dao.UserGroupDao;
import saeut.dao.BoardDao;
import saeut.domain.UserEssential;
import saeut.domain.UserGroup;
import saeut.domain.UserAdditional;
import saeut.domain.LoginInfo;
import saeut.domain.Board;
import saeut.service.facade.MyPageFacade;

@Repository
@Service("mypageImpl")
@Transactional
public class MyPageImpl implements MyPageFacade{

	@Autowired
	private UserEssentialDao UserEssentialDao;
	@Autowired
	private UserAdditionalDao UserAdditionalDao;
	@Autowired
	private UserGroupDao userGroupDao;
	@Autowired
	private BoardDao boardDao;
	/*
	 * UserEssentialDao
	 */
	@Override
	public UserEssential getUserEssentialByUserId(String id) {
		return UserEssentialDao.getUserEssentialByUserId(id);
	}

//	@Override
//	public UserEssential getUserEssentialByUserIdAndPassword(UserEssential UserEssential) {
//		return UserEssentialDao.getUserEssentialByUserIdAndPassword(UserEssential);
//	};
//	
	
	@Override
	public UserEssential getUserEssentialByUserIdAndPassword(LoginInfo loginInfo) {
		return UserEssentialDao.getUserEssentialByUserIdAndPassword(loginInfo);
	};
	
	@Override
	public boolean isIdDuplicated(String id) {
		return UserEssentialDao.isIdDuplicated(id);
	}

	
	@Override
	public List<UserEssential> getAllUserEssential(){
		return UserEssentialDao.getAllUserEssential();
	}
	
	@Override
	public String getNicknameByUserID(String id) {
		// TODO Auto-generated method stub
		return UserEssentialDao.getNicknameByUserID(id);
	}
	
	@Override
	public void insertUserEssential(UserEssential UserEssential) {
		UserEssentialDao.insertUserEssential(UserEssential);
	};
		
    @Override
	public void modUserEssential(UserEssential UserEssential) {
    	UserEssentialDao.modUserEssential(UserEssential);
    };
		
	@Override
	public void removeUserEssential(String userId) {
		UserEssentialDao.removeUserEssential(userId);
	}

	/*
	 * UserAdditionalDao
	 */
	
	@Override
	public List<UserAdditional> getAllUserAdditional() {
		return UserAdditionalDao.getAllUserAdditional();
	}

	@Override
	public UserAdditional getUserAdditionalByUserId(String userId) {
		return UserAdditionalDao.getUserAdditionalByUserId(userId);
	}

	@Override
	public void insertUserAdditional(UserAdditional UserAdditional) {
		UserAdditionalDao.insertUserAdditional(UserAdditional);
	}

	@Override
	public void modUserAdditional(UserAdditional UserAdditional) {
		UserAdditionalDao.modUserAdditional(UserAdditional);
	}

	@Override
	public void removeUserAdditional(String userId) {
		UserAdditionalDao.removeUserAdditional(userId);
	}

	@Override
	public boolean isNickDuplicated(String nickname) {
		return UserAdditionalDao.isNickDuplicated(nickname);
	}

	@Override
	public List<UserGroup> getAllUserGroup() {
		// TODO Auto-generated method stub
		return userGroupDao.getAllUserGroup();
	}

	@Override
	public List<UserGroup> getUserGroupByUserId(String userId) {
		// TODO Auto-generated method stub
		return userGroupDao.getUserGroupByUserId(userId);
	}

	@Override
	public List<UserGroup> getUserGroupByType(int type) {
		// TODO Auto-generated method stub
		return userGroupDao.getUserGroupByType(type);
	}

	@Override
	public List<UserGroup> getUserGroupByPost_id(int post_id) {
		// TODO Auto-generated method stub
		return userGroupDao.getUserGroupByPost_id(post_id);
	}

	@Override
	public void insertUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		userGroupDao.insertUserGroup(userGroup);
	}

	@Override
	public void modUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		userGroupDao.modUserGroup(userGroup);
	}

	@Override
	public void removeUserGroup(String userID) {
		// TODO Auto-generated method stub
		userGroupDao.removeUserGroup(userID);
	}

	@Override
	public List<Board> getAllBoard() {
		// TODO Auto-generated method stub
		return boardDao.getAllBoard();
	}

	@Override
	public List<Board> getBoardByUserId(String userid) {
		// TODO Auto-generated method stub
		return boardDao.getBoardByUserId(userid);
	}

	@Override
	public List<Board> getBoardByPost_id(int post_id) {
		// TODO Auto-generated method stub
		return boardDao.getBoardByPost_id(post_id);
	}

	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		boardDao.insertBoard(board);
	}

	@Override
	public void modBoard(Board board) {
		// TODO Auto-generated method stub
		boardDao.modBoard(board);
	}

	@Override
	public void removeBoard(int post_id) {
		// TODO Auto-generated method stub
		boardDao.removeBoard(post_id);
	}
	
}
