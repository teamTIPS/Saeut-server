package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import saeut.dao.ApplyDao;
import saeut.dao.mybatis.mapper.ApplyMapper;
import saeut.domain.Apply;

@Repository
public class MybatisApplyDao implements ApplyDao{

	@Autowired
	private ApplyMapper applyMapper;
	
	@Override
	public List<Apply> getAllApply() throws DataAccessException {
		return applyMapper.getAllApply();
	}

	@Override
	public List<Apply> getApplytByUserId(String userId) throws DataAccessException {
		return applyMapper.getApplytByUserId(userId);
	}

	@Override
	public List<Apply> getApplytByPostId(String postId) throws DataAccessException {
		return applyMapper.getApplytByPostId(postId);
	}

	@Override
	public void insertApply(Apply apply) throws DataAccessException {
		applyMapper.insertApply(apply);
		
	}

	@Override
	public void removeApply(int postId) throws DataAccessException {
		applyMapper.removeApply(postId);
	}

}
