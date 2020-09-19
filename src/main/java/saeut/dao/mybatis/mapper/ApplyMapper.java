package saeut.dao.mybatis.mapper;

import java.util.List;

import saeut.domain.Apply;

public interface ApplyMapper {

	List<Apply> getAllApply();
	
	List<Apply> getApplyByUserId(String userId);
	
	List<Apply> getApplyByPostId(int postId); 
	
	void insertApply(Apply apply);
	
	void removeApply(int postId);
	
	int countApplyByPostId(int postId);
}
