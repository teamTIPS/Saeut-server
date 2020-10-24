package saeut.service.facade;

import java.util.List;

import saeut.domain.CheckList;
import saeut.domain.Comment;
import saeut.domain.Post;
import saeut.domain.Tag;

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
	
	/////////////////////////////////////////////////////////////////////////
	/* 사용자가 작성하는 Comment */
	///////////////////////////////////////////////////////////////////////
	List<Comment> getCommentByUserId(String id);	
	List<Comment> getAllComment(); 	
	void insertComment(Comment comment);	
	void modComment(Comment comment);	
	void removeComment(int commet_id);
	
	/////////////////////////////////////////////////////////////////////////
	/* Post에 할당되는 Tag */
	///////////////////////////////////////////////////////////////////////
	List<Tag> getAllTag();
	List<Tag> getTagByPostID(int post_id);
	void insertTag(Tag tag);
	void removeTag(int post_id);
	
	
}
