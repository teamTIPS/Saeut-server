package saeut.service.facade;

import java.util.List;

import saeut.domain.CheckList;
import saeut.domain.Post;

public interface PostFacade {

	/////////////////////////////////////////////////////////////////////////
	/* 돌봄 요청자가 올리는 Post */
	/////////////////////////////////////////////////////////////////////////
	
	List<Post> getAllPost();
	List<Post> getPostByUserId(String userId);
	List<Post> getPostByType(int type);
	List<Post> getPostByTitle(String title);
	void insertPost(Post Post);
	void modPost(Post Post);
	void removePost(int post_id);
	boolean isExistPostId(int post_id);
	
	/////////////////////////////////////////////////////////////////////////
	/* 돌봄 요청자가 체크하는 CheckList */
	/////////////////////////////////////////////////////////////////////////

	List<CheckList> getAllCheckList();
	List<CheckList> getTop6CheckList();
				
	
}
