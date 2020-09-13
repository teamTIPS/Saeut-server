package saeut.domain;

import java.util.Date;

public class Auth {
	private String id;
	private String refreshToken;
	private Date refreshToken_expireTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getRefreshToken_expiretime() {
		return this.getRefreshToken_expiretime();
	}
	public void setRefreshToken_expiretime(Date refreshToken_expireTime) {
		this.refreshToken_expireTime = refreshToken_expireTime;
	}

}
