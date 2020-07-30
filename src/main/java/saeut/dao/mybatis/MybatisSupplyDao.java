package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import saeut.dao.SupplyDao;
import saeut.dao.mybatis.mapper.SupplyMapper;
import saeut.domain.Supply;

@Repository
public class MybatisSupplyDao implements SupplyDao {

	@Autowired
	private SupplyMapper supplyMapper;
	
	@Override
	public Supply getSupplyByUserId(String id) throws DataAccessException {
		return supplyMapper.getSupplyByUserId(id);
	}
	
	@Override
	public List<Supply> getAllSupply() throws DataAccessException{
		return supplyMapper.getAllSupply();
	};
	
	@Override
	public void insertSupply(Supply supply) {
		supplyMapper.insertSupply(supply);
	};
		
    @Override
	public void modSupply(Supply supply) {
    	supplyMapper.modSupply(supply);
    };
		
	@Override
	public void removeSupply(String userId) {
		supplyMapper.removeSupply(userId);
	};
	
	

	
}
