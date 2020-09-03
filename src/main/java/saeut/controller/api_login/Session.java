package saeut.controller.api_login;

import java.util.Date;

public class Session {
	
	private String account_id;
	private String accessToken;
	private String refreshToken;
	private Date accessToken_expireTime;
	private Date refreshToken_expireTime;
	
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public Date getAccessToken_expireTime() {
		return accessToken_expireTime;
	}
	public void setAccessToken_expireTime(Date accessToken_expireTime) {
		this.accessToken_expireTime = accessToken_expireTime;
	}
	public Date getRefreshToken_expireTime() {
		return refreshToken_expireTime;
	}
	public void setRefreshToken_expireTime(Date refreshToken_expireTime) {
		this.refreshToken_expireTime = refreshToken_expireTime;
	}
	
}
