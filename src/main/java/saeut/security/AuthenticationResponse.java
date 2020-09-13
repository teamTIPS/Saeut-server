package saeut.security;

import saeut.domain.UserEssential;

/**
 * 인증처리후 반환값
 */
public class AuthenticationResponse {

	private Jwt jwt;
	private UserEssential userEssential;

	public AuthenticationResponse(Jwt jwt) {
		super();
		this.jwt = jwt;
	}
	
	public AuthenticationResponse(Jwt jwt, UserEssential userEssential) {
		super();
		this.jwt = jwt;
		this.userEssential = userEssential;
	}

	public Jwt getJwt() {
		return jwt;
	}

	public void setJwt(Jwt jwt) {
		this.jwt = jwt;
	}
	
	public UserEssential getUserEssential() {
		return userEssential;
	}
	
	public void setUserEssential(UserEssential userEssential) {
		this.userEssential = userEssential;
	}

	@Override
	public String toString() {
		return "AuthenticationResponse [jwt=" + jwt + ", userEssential= "+userEssential+"]";
	}
	
	
}
