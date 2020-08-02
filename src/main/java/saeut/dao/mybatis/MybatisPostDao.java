package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	
}
