package saeut.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.Post;

public interface PostDao {

	// 모든 Post 가져오기
	List<Post> getAllPost() throws DataAccessException;
			
	// userId로 Post 가져오기
	List<Post> getPostByUserId(String userId) throws DataAccessException;
			
	// Post 추가하기
	void insertPost(Post Post) throws DataAccessException;
			
	// Post 수정하기
	void modPost(Post Post) throws DataAccessException;
			
	// userId로 Post 삭제하기
	void removePost(int post_id) throws DataAccessException;
}
