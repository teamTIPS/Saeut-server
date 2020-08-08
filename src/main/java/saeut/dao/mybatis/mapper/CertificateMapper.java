package saeut.dao.mybatis.mapper;

import java.util.List;

import saeut.domain.Certificate;

public interface CertificateMapper {

	// userId로 Certificate 가져오기
	List<Certificate> getCertificateByUserId(String userId);
	
	// 모든 Certificate 가져오기
	List<Certificate> getAllCertificate();
	
	// tag 종류에 따라 Certificate 가져오기
	List<Certificate> getCertificateByTag(int tag);
	
	// Certificate 추가하기
	void insertCertificate(Certificate certificate);
	
	// Certificate 수정하기
	void modCertificate(Certificate certificate);
	
	// cert_id로 Certificate 삭제하기
	void removeCertificate(int cert_id);
	
}
