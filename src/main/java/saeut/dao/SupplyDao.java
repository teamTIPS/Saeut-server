package saeut.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.Supply;

public interface SupplyDao {

	// 모든 Supply 가져오기
	List<Supply> getAllSupply() throws DataAccessException;
	
	// userId로 Supply 가져오기
	Supply getSupplyByUserId(String userId) throws DataAccessException;
	
	// Supply 추가하기
	void insertSupply(Supply supply) throws DataAccessException;
	
	// Supply 수정하기
	void modSupply(Supply supply) throws DataAccessException;
	
	// userId로 Supply 삭제하기
	void removeSupply(String userId) throws DataAccessException;
}
