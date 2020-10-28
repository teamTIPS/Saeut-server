package saeut.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.Comment;

public interface CommentDao {

	List<Comment> getCommentByUserId(String id);
	
	List<Comment> getAllComment(); 
	
	List<Comment> getCommentByPostId(int post_id);
	
	void insertComment(Comment comment);
	
	void modComment(Comment comment);
	
	void removeComment(int commet_id);
}
