package saeut.dao.mybatis.mapper;

import java.util.List;

import saeut.domain.Demand;

public interface DemandMapper {

	// 모든 Demand 가져오기
	List<Demand> getAllDemand();
	
	// userId로 Demand 가져오기
	Demand getDemandByUserId(String userId);
	
	// Demand 추가하기
	void insertDemand(Demand demand);
	
	// Demand 수정하기
	void modDemand(Demand demand);
	
	// userId로 Demand 삭제하기
	void removeDemand(String userId);
	
}
