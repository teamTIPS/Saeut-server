package saeut.dao.mybatis.mapper;

import java.util.List;

import saeut.domain.Supply;

public interface SupplyMapper {

	// 모든 Supply 가져오기
	List<Supply> getAllSupply();
	
	// userId로 Supply 가져오기
	Supply getSupplyByUserId(String userId);
	
	// Supply 추가하기
	void insertSupply(Supply supply);
	
	// Supply 수정하기
	void modSupply(Supply supply);
	
	// userId로 Supply 삭제하기
	void removeSupply(String userId);
	
}
