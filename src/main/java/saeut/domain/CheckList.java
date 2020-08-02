package saeut.domain;

import java.io.Serializable;

/*
* CheckList Domain Class
* */
@SuppressWarnings("serial")
public class CheckList implements Serializable{
	
	private int cert_id; // (FK, PK) 
	private String name; // 자격증 이름 
	private boolean checked; // 요청자가 체크박스 체크 여부 
	
	public int getCert_id() {
		return cert_id;
	}
	public void setCert_id(int cert_id) {
		this.cert_id = cert_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}
