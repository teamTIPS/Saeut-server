package saeut.dao.mybatis.mapper;

import java.util.List;
import saeut.domain.Comment;

import org.springframework.dao.DataAccessException;

import saeut.domain.Post;

public interface CommentMapper {

	List<Comment> getCommentByUserId(String id);
	
	List<Comment> getAllComment(); 
	
	void insertComment(Comment comment);
	
	void modComment(Comment comment);
	
	void removeComment(int commet_id);
}
