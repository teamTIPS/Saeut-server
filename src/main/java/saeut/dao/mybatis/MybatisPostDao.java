package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import saeut.dao.PostDao;
import saeut.dao.mybatis.mapper.PostMapper;
import saeut.domain.Post;

@Repository
public class MybatisPostDao implements PostDao{

	@Autowired
	private PostMapper postMapper;
	
	@Override
	public List<Post> getAllPost() {
		return postMapper.getAllPost();
	}

	@Override
	public List<Post> getPostByUserId(String userId) {
		return postMapper.getPostByUserId(userId);
	}
	
	@Override
	public List<Post> getPostByType(int type) throws DataAccessException {
		// TODO Auto-generated method stub
		return postMapper.getPostByType(type);
	}

	@Override
	public List<Post> getPostByTitle(String title) throws DataAccessException {
		// TODO Auto-generated method stub
		return postMapper.getPostByTitle(title);
	}

	@Override
	public void insertPost(Post Post) {
		postMapper.insertPost(Post);	
	}

	@Override
	public void modPost(Post Post) {
		postMapper.modPost(Post);
	}

	@Override
	public void removePost(int post_id) {
		postMapper.removePost(post_id);
		
	}

	@Override
	public boolean isExistPostId(int post_id) throws DataAccessException {
		return postMapper.isExistPostId(post_id);
	}

	

	
}
