package saeut.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import saeut.dao.mybatis.mapper.UserEssentialMapper;
import saeut.domain.UserEssential;

/**
 * 사용자 처리 서비스
 */
@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Setter(onMethod_ = {@Autowired })
	private UserEssentialMapper UserEssentialMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEssential UserEssential = UserEssentialMapper.getUserEssentialByUserId(username);
		
		return UserEssential == null? null : new CustomUser(UserEssential);
	}
}
