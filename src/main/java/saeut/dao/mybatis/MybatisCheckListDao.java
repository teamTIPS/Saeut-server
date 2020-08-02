package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import saeut.dao.CheckListDao;
import saeut.dao.mybatis.mapper.CheckListMapper;
import saeut.domain.CheckList;

@Repository
public class MybatisCheckListDao implements CheckListDao{

	@Autowired
	private CheckListMapper checkListMapper;
	
	@Override
	public List<CheckList> getAllCheckList() {
		return checkListMapper.getAllCheckList();
	}

	@Override
	public List<CheckList> getTop6CheckList() {
		return checkListMapper.getTop6CheckList();
	}

	
}
