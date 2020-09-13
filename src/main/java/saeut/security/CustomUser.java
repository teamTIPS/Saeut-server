package saeut.security;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import saeut.domain.UserEssential;
import lombok.Getter;

@Getter
public class CustomUser extends User {
	
	private static final long serialVersionUID = 1L;
	
	private UserEssential UserEssential;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	
	public CustomUser(UserEssential UserEssential) {
		
		super(UserEssential.getId(),UserEssential.getPassword(),new ArrayList<>());
		
		this.UserEssential = UserEssential;
	}

}
