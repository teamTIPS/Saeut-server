package saeut.dao.mybatis.mapper;

import java.util.List;

import saeut.domain.Post;

public interface PostMapper {

	// 모든 Post 가져오기
	List<Post> getAllPost();
		
	// userId로 Post 가져오기
	Post getPostByUserId(String userId);
		
	// Post 추가하기
	void insertPost(Post Post);
		
	// Post 수정하기
	void modPost(Post Post);
		
	// userId로 Post 삭제하기
	void removePost(String userId);
}
