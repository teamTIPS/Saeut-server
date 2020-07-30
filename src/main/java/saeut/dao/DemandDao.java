package saeut.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.Demand;

public interface DemandDao {

	// 모든 Demand 가져오기
	List<Demand> getAllDemand() throws DataAccessException;
	
	// userId로 Demand 가져오기
	Demand getDemandByUserId(String userId) throws DataAccessException;
	
	// Demand 추가하기
	void insertDemand(Demand demand) throws DataAccessException;
	
	// Demand 수정하기
	void modDemand(Demand demand) throws DataAccessException;
	
	// userId로 Demand 삭제하기
	void removeDemand(String userId) throws DataAccessException;
}
