package saeut.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.Apply;

public interface ApplyDao {


	List<Apply> getAllApply() throws DataAccessException;
	
	List<Apply> getApplytByUserId(String userId) throws DataAccessException;
	
	List<Apply> getApplytByPostId(String postId) throws DataAccessException; 
	
	void insertApply(Apply apply) throws DataAccessException;
	
	void removeApply(int postId) throws DataAccessException;
}
