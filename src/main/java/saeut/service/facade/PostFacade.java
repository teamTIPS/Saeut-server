package saeut.service.facade;

import java.util.List;

import saeut.domain.CheckList;
import saeut.domain.Post;

public interface PostFacade {

	/////////////////////////////////////////////////////////////////////////
	/* 돌봄 요청자가 올리는 Post */
	/////////////////////////////////////////////////////////////////////////
	
	List<Post> getAllPost();
	Post getPostByUserId(String userId);
	void insertPost(Post Post);
	void modPost(Post Post);
	void removePost(String userId);
	
	/////////////////////////////////////////////////////////////////////////
	/* 돌봄 요청자가 체크하는 CheckList */
	/////////////////////////////////////////////////////////////////////////

	List<CheckList> getAllCheckList();
	List<CheckList> getTop6CheckList();
				
	
}
