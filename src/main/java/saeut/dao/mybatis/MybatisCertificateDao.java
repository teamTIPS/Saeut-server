package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import saeut.dao.CertificateDao;
import saeut.dao.mybatis.mapper.CertificateMapper;
import saeut.domain.Certificate;

@Repository
public class MybatisCertificateDao implements CertificateDao {

	@Autowired
	private CertificateMapper certificateMapper;
	
	@Override
	public List<Certificate> getCertificateByUserId(String id) throws DataAccessException {
		return certificateMapper.getCertificateByUserId(id);
	}
	
	@Override
	public List<Certificate> getAllCertificate() throws DataAccessException{
		return certificateMapper.getAllCertificate();
	};
	
	@Override
	public void insertCertificate(Certificate certificate) {
		certificateMapper.insertCertificate(certificate);
	};
		
    @Override
	public void modCertificate(Certificate certificate) {
    	certificateMapper.modCertificate(certificate);
    };
		
	@Override
	public void removeCertificate(int cert_id) {
		certificateMapper.removeCertificate(cert_id);
	}

	@Override
	public List<Certificate> getCertificateByTag(int tag) throws DataAccessException {
		return certificateMapper.getCertificateByTag(tag);
	};

	
}
