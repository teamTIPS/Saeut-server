package saeut.security;

import saeut.domain.UserEssential;
import saeut.domain.UserAdditional;

/**
 * 인증처리후 반환값
 */
public class AuthenticationResponse {

	private Jwt jwt;
	private UserEssential userEssential;
	private UserAdditional userAdditional;

	public AuthenticationResponse(Jwt jwt) {
		super();
		this.jwt = jwt;
	}
	
	public AuthenticationResponse(Jwt jwt, UserEssential userEssential, UserAdditional userAdditional) {
		super();
		this.jwt = jwt;
		this.userEssential = userEssential;
		this.userAdditional = userAdditional;
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
	
	public UserAdditional getUserAdditional() {
		return userAdditional;
	}
	public void setUserAdditional(UserAdditional userAdditional) {
		this.userAdditional = userAdditional;
	}

	@Override
	public String toString() {
		return "AuthenticationResponse [jwt=" + jwt + ", userEssential= "+userEssential+
				", userAdditional= "+userAdditional+"]";
	}
	
	
}
