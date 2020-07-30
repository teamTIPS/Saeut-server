package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import saeut.dao.DemandDao;
import saeut.dao.mybatis.mapper.DemandMapper;
import saeut.domain.Demand;

@Repository
public class MybatisDemandDao implements DemandDao {

	@Autowired
	private DemandMapper demandMapper;
	
	@Override
	public Demand getDemandByUserId(String id) throws DataAccessException {
		return demandMapper.getDemandByUserId(id);
	}
	
	@Override
	public List<Demand> getAllDemand() throws DataAccessException{
		return demandMapper.getAllDemand();
	};
	
	@Override
	public void insertDemand(Demand demand) {
		demandMapper.insertDemand(demand);
	};
		
    @Override
	public void modDemand(Demand demand) {
    	demandMapper.modDemand(demand);
    };
		
	@Override
	public void removeDemand(String userId) {
		demandMapper.removeDemand(userId);
	};
	
	

	
}
