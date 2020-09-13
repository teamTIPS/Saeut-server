package saeut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import saeut.dao.UserEssentialDao;
import saeut.dao.CertificateDao;
import saeut.dao.UserAdditionalDao;
import saeut.domain.UserEssential;
import saeut.domain.Certificate;
import saeut.domain.UserAdditional;
import saeut.domain.LoginInfo;
import saeut.service.facade.MyPageFacade;

@Repository
@Service("mypageImpl")
@Transactional
public class MyPageImpl implements MyPageFacade{

	@Autowired
	private UserEssentialDao UserEssentialDao;
	@Autowired
	private CertificateDao certificateDao;
	@Autowired
	private UserAdditionalDao UserAdditionalDao;
	
	/*
	 * UserEssentialDao
	 */
	@Override
	public UserEssential getUserEssentialByUserId(String id) {
		return UserEssentialDao.getUserEssentialByUserId(id);
	}

//	@Override
//	public UserEssential getUserEssentialByUserIdAndPassword(UserEssential UserEssential) {
//		return UserEssentialDao.getUserEssentialByUserIdAndPassword(UserEssential);
//	};
//	
	
	@Override
	public UserEssential getUserEssentialByUserIdAndPassword(LoginInfo loginInfo) {
		return UserEssentialDao.getUserEssentialByUserIdAndPassword(loginInfo);
	};
	
	@Override
	public int isDuplicated(LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		return UserEssentialDao.isDuplicated(loginInfo);
	}

	
	
	@Override
	public List<UserEssential> getAllUserEssential(){
		return UserEssentialDao.getAllUserEssential();
	}
	
	@Override
	public String getNicknameByUserID(String id) {
		// TODO Auto-generated method stub
		return UserEssentialDao.getNicknameByUserID(id);
	}
	
	@Override
	public void insertUserEssential(UserEssential UserEssential) {
		UserEssentialDao.insertUserEssential(UserEssential);
	};
		
    @Override
	public void modUserEssential(UserEssential UserEssential) {
    	UserEssentialDao.modUserEssential(UserEssential);
    };
		
	@Override
	public void removeUserEssential(String userId) {
		UserEssentialDao.removeUserEssential(userId);
	}

	/*
	 * CertificateDao
	 */
	@Override
	public List<Certificate> getAllCertificate() {
		return certificateDao.getAllCertificate();
	}

	@Override
	public List<Certificate> getCertificateByUserId(String userId) {
		return certificateDao.getCertificateByUserId(userId);
	}
	
	@Override
	public List<Certificate> getCertificateByTag(int tag) {
		return certificateDao.getCertificateByTag(tag);
	}

	@Override
	public void insertCertificate(Certificate certificate) {
		certificateDao.insertCertificate(certificate);
	}

	@Override
	public void modCertificate(Certificate certificate) {
		certificateDao.modCertificate(certificate);
	}

	@Override
	public void removeCertificate(int cert_id) {
		certificateDao.removeCertificate(cert_id);
	}

	/*
	 * UserAdditionalDao
	 */
	
	@Override
	public List<UserAdditional> getAllUserAdditional() {
		return UserAdditionalDao.getAllUserAdditional();
	}

	@Override
	public UserAdditional getUserAdditionalByUserId(String userId) {
		return UserAdditionalDao.getUserAdditionalByUserId(userId);
	}

	@Override
	public void insertUserAdditional(UserAdditional UserAdditional) {
		UserAdditionalDao.insertUserAdditional(UserAdditional);
	}

	@Override
	public void modUserAdditional(UserAdditional UserAdditional) {
		UserAdditionalDao.modUserAdditional(UserAdditional);
	}

	@Override
	public void removeUserAdditional(String userId) {
		UserAdditionalDao.removeUserAdditional(userId);
	}
	
}
