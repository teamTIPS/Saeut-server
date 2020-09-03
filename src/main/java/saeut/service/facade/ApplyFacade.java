package saeut.service.facade;

import java.util.List;

import saeut.domain.Apply;

public interface ApplyFacade {

	List<Apply> getAllApply();
	
	List<Apply> getApplytByUserId(String userId);
	
	List<Apply> getApplytByPostId(String postId); 
	
	void insertApply(Apply apply);
	
	void removeApply(int postId);
}
