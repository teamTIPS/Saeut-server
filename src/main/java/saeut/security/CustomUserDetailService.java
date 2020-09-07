package saeut.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import saeut.dao.mybatis.mapper.AccountMapper;
import saeut.domain.Account;

/**
 * 사용자 처리 서비스
 */
@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Setter(onMethod_ = {@Autowired })
	private AccountMapper accountMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account account = accountMapper.getAccountByUserId(username);
		
		return account == null? null : new CustomUser(account);
	}
}
