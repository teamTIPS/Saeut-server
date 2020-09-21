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
	public List<Apply> getApplyByUserId(String userId) throws DataAccessException {
		return applyMapper.getApplyByUserId(userId);
	}

	@Override
	public List<Apply> getApplyByPostId(int postId) throws DataAccessException {
		return applyMapper.getApplyByPostId(postId);
	}

	@Override
	public void insertApply(Apply apply) throws DataAccessException {
		applyMapper.insertApply(apply);
		
	}

	@Override
	public void removeApply(int postId) throws DataAccessException {
		applyMapper.removeApply(postId);
	}
	
	@Override
	public int getApplyCount(int postId) throws DataAccessException {
		return applyMapper.getApplyCount(postId);
	}

	@Override
	public boolean isVaildId(String id, int postId) throws DataAccessException {
		return applyMapper.isVaildId(id, postId);
	}

	@Override
	public boolean isAlreadyApply(String id, int postId) throws DataAccessException {
		return applyMapper.isAlreadyApply(id, postId);
	}

	
}
