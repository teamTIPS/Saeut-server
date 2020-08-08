package saeut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import saeut.dao.AccountDao;
import saeut.dao.CertificateDao;
import saeut.dao.DemandDao;
import saeut.dao.SupplyDao;
import saeut.domain.Account;
import saeut.domain.Certificate;
import saeut.domain.Demand;
import saeut.domain.Supply;
import saeut.service.facade.MyPageFacade;

@Repository
@Service("mypageImpl")
@Transactional
public class MyPageImpl implements MyPageFacade{

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private CertificateDao certificateDao;
	@Autowired
	private DemandDao demandDao;
	@Autowired
	private SupplyDao supplyDao;
	
	/*
	 * AccountDao
	 */
	@Override
	public Account getAccountByUserId(String id) {
		return accountDao.getAccountByUserId(id);
	}

	@Override
	public Account getAccountByUserIdAndPassword(Account account) {
		return accountDao.getAccountByUserIdAndPassword(account);
	};
	
	@Override
	public List<Account> getAllAccount(){
		return accountDao.getAllAccount();
	}
	
	@Override
	public String getNicknameByUserID(String id) {
		// TODO Auto-generated method stub
		return accountDao.getNicknameByUserID(id);
	}
	
	@Override
	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	};
		
    @Override
	public void modAccount(Account account) {
    	accountDao.modAccount(account);
    };
		
	@Override
	public void removeAccount(String userId) {
		accountDao.removeAccount(userId);
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
	 * DemandDao
	 */
	
	@Override
	public List<Demand> getAllDemand() {
		return demandDao.getAllDemand();
	}

	@Override
	public Demand getDemandByUserId(String userId) {
		return demandDao.getDemandByUserId(userId);
	}

	@Override
	public void insertDemand(Demand demand) {
		demandDao.insertDemand(demand);
	}

	@Override
	public void modDemand(Demand demand) {
		demandDao.modDemand(demand);
	}

	@Override
	public void removeDemand(String userId) {
		demandDao.removeDemand(userId);
	}

	/*
	 * SupplyDao
	 */
	
	@Override
	public List<Supply> getAllSupply() {
		return supplyDao.getAllSupply();
	}

	@Override
	public Supply getSupplyByUserId(String userId) {
		return supplyDao.getSupplyByUserId(userId);
	}

	@Override
	public void insertSupply(Supply supply) {
		supplyDao.insertSupply(supply);
	}

	@Override
	public void modSupply(Supply supply) {
		supplyDao.modSupply(supply);
	}

	@Override
	public void removeSupply(String userId) {
		supplyDao.removeSupply(userId);
	}

	

	
}
