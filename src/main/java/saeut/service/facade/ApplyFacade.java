package saeut.service.facade;

import java.util.List;
import saeut.domain.Apply;

public interface ApplyFacade {

	List<Apply> getAllApply();
	
	List<Apply> getApplyByUserId(String userId);
	
	List<Apply> getApplyByPostId(int postId); 
	
	void insertApply(Apply apply);
	
	void removeApply(int postId);
	
	int getApplyCount(int postId);

	boolean isVaildId(String id, int postId);
	
	boolean isAlreadyApply(String id, int postId);

}
