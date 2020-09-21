package saeut.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.Apply;

public interface ApplyDao {


	List<Apply> getAllApply() throws DataAccessException;
	
	List<Apply> getApplyByUserId(String userId) throws DataAccessException;
	
	List<Apply> getApplyByPostId(int postId) throws DataAccessException; 
	
	void insertApply(Apply apply) throws DataAccessException;
	
	void removeApply(int postId) throws DataAccessException;
	
	int getApplyCount(int postId) throws DataAccessException;
	
	boolean isVaildId(String id, int postId) throws DataAccessException;
	
	boolean isAlreadyApply(String id, int postId) throws DataAccessException;
}
