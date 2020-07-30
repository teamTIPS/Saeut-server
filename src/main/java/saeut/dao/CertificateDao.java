package saeut.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.Certificate;

public interface CertificateDao {

	// 모든 Certificate 가져오기
	List<Certificate> getAllCertificate() throws DataAccessException;
		
	// userId로 Certificate 가져오기
	List<Certificate> getCertificateByUserId(String userId) throws DataAccessException;
		
	// Certificate 추가하기
	void insertCertificate(Certificate certificate) throws DataAccessException;
		
	// Certificate 수정하기
	void modCertificate(Certificate certificate) throws DataAccessException;
		
	// cert_id로 Certificate 삭제하기
	void removeCertificate(int cert_id) throws DataAccessException;
}
