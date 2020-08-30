package saeut.service.facade;

import java.util.List;

import saeut.domain.Account;
import saeut.domain.Certificate;
import saeut.domain.Demand;
import saeut.domain.LoginInfo;
import saeut.domain.Supply;

public interface MyPageFacade {

	/////////////////////////////////////////////////////////////////////////
	/* Account */
	/////////////////////////////////////////////////////////////////////////
	Account getAccountByUserId(String id);
	Account getAccountByUserIdAndPassword(LoginInfo loginInfo);		
	List<Account> getAllAccount();
	String getNicknameByUserID(String id);
	void insertAccount(Account account);
	void modAccount(Account account);
	void removeAccount(String id);
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
	/* Demand */
	/////////////////////////////////////////////////////////////////////////	
	List<Demand> getAllDemand();
	Demand getDemandByUserId(String userId);
	void insertDemand(Demand demand);
	void modDemand(Demand demand);
	void removeDemand(String userId);
	/////////////////////////////////////////////////////////////////////////
	/* Supply */
	/////////////////////////////////////////////////////////////////////////	
	List<Supply> getAllSupply();
	Supply getSupplyByUserId(String userId);
	void insertSupply(Supply supply);
	void modSupply(Supply supply);
	void removeSupply(String userId);

}
