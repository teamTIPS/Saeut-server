package saeut.service.facade;

import java.util.List;

import saeut.domain.UserEssential;
import saeut.domain.Certificate;
import saeut.domain.UserAdditional;
import saeut.domain.LoginInfo;

public interface MyPageFacade {

	/////////////////////////////////////////////////////////////////////////
	/* UserEssential */
	/////////////////////////////////////////////////////////////////////////
	UserEssential getUserEssentialByUserId(String id);
	UserEssential getUserEssentialByUserIdAndPassword(LoginInfo loginInfo);		
	List<UserEssential> getAllUserEssential();
	String getNicknameByUserID(String id);
	void insertUserEssential(UserEssential UserEssential);
	void modUserEssential(UserEssential UserEssential);
	void removeUserEssential(String id);
	int isDuplicated(LoginInfo loginInfo);
	/////////////////////////////////////////////////////////////////////////
	/* Certificate */
	/////////////////////////////////////////////////////////////////////////	
	List<Certificate> getAllCertificate();
	List<Certificate> getCertificateByUserId(String userId);
	List<Certificate> getCertificateByTag(int tag);
	void insertCertificate(Certificate certificate);
	void modCertificate(Certificate certificate);
	void removeCertificate(int cert_id);
	/////////////////////////////////////////////////////////////////////////
	/* UserAdditional */
	/////////////////////////////////////////////////////////////////////////	
	List<UserAdditional> getAllUserAdditional();
	UserAdditional getUserAdditionalByUserId(String userId);
	void insertUserAdditional(UserAdditional UserAdditional);
	void modUserAdditional(UserAdditional UserAdditional);
	void removeUserAdditional(String userId);
	boolean isNickDuplicated(String nickname);

}
