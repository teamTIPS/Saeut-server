package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import saeut.dao.TagDao;
import saeut.dao.mybatis.mapper.TagMapper;
import saeut.domain.Tag;

@Repository
public class MybatisTagDao implements TagDao{

	@Autowired
	private TagMapper tagMapper;

	@Override
	public List<Tag> getAllTag() {
		// TODO Auto-generated method stub
		return tagMapper.getAllTag();
	}

	@Override
	public List<Tag> getTagByPostID(int post_id) {
		// TODO Auto-generated method stub
		return tagMapper.getTagByPostID(post_id);
	}

	@Override
	public void insertTag(Tag tag) {
		// TODO Auto-generated method stub
		tagMapper.insertTag(tag);
	}

	@Override
	public void removeTag(int post_id) {
		// TODO Auto-generated method stub
		tagMapper.removeTag(post_id);
	}
	

	

	
}
