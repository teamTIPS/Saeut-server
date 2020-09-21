package saeut.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.Post;

public interface PostMapper {

	// 모든 Post 가져오기
	List<Post> getAllPost();
		
	// userId로 Post 가져오기
	List<Post> getPostByUserId(String userId);
	
	// type으로 Post 가져오기
	List<Post> getPostByType(int type);
		
	// title로 Post 가져오기
	List<Post> getPostByTitle(String title);
		
	// Post 추가하기
	void insertPost(Post Post);
		
	// Post 수정하기
	void modPost(Post Post);
		
	// userId로 Post 삭제하기
	void removePost(int post_id);
	
	boolean isExistPostId(int post_id);
}
