package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import saeut.dao.CommentDao;
import saeut.dao.mybatis.mapper.CommentMapper;
import saeut.domain.Comment;

@Repository
public class MybatisCommentDao implements CommentDao{

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<Comment> getCommentByUserId(String id) {
		// TODO Auto-generated method stub
		return commentMapper.getCommentByUserId(id);
	}

	@Override
	public List<Comment> getAllComment() {
		// TODO Auto-generated method stub
		return commentMapper.getAllComment();
	}

	@Override
	public void insertComment(Comment comment) {
		// TODO Auto-generated method stub
		commentMapper.insertComment(comment);
	}

	@Override
	public void modComment(Comment comment) {
		// TODO Auto-generated method stub
		commentMapper.modComment(comment);
	}

	@Override
	public void removeComment(int commet_id) {
		// TODO Auto-generated method stub
		commentMapper.removeComment(commet_id);
	}

	

	
}
