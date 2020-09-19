package saeut.service.facade;

import java.util.List;

import saeut.domain.Apply;

public interface ApplyFacade {

	List<Apply> getAllApply();
	
	List<Apply> getApplyByUserId(String userId);
	
	List<Apply> getApplyByPostId(int postId); 
	
	void insertApply(Apply apply);
	
	void removeApply(int postId);
	
	int countApplyByPostId(int postId);
}
