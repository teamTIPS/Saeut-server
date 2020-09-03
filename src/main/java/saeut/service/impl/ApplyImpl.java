package saeut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import saeut.dao.ApplyDao;
import saeut.domain.Apply;
import saeut.service.facade.ApplyFacade;

@Repository
@Service("applyImpl")
@Transactional
public class ApplyImpl implements ApplyFacade{
	
	@Autowired
	private ApplyDao applyDao;

	@Override
	public List<Apply> getAllApply() {
		return applyDao.getAllApply();
	}

	@Override
	public List<Apply> getApplytByUserId(String userId) {
		return applyDao.getApplytByUserId(userId);
	}

	@Override
	public List<Apply> getApplytByPostId(String postId) {
		return applyDao.getApplytByPostId(postId);
	}

	@Override
	public void insertApply(Apply apply) {
		applyDao.insertApply(apply);
	}

	@Override
	public void removeApply(int postId) {
		applyDao.removeApply(postId);
		
	}

}
