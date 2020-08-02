package saeut.domain;

import java.io.Serializable;
//import java.sql.Date; 둘중에 어떤건지 다시 체크하기 
import java.util.Date;

/*
* Certificate Domain Class
* */
@SuppressWarnings("serial")
public class Certificate implements Serializable {
	
	private String cert_id; //(PK)
	private String cert_name; //자격증 이름
	private Date cert_date; //자격증 취득 날짜
	private String cert_inst; //발행 기관 이름 
	private String id; // (FK)
	private int check_type; // (FK)
	
	public String getCert_id() {
		return cert_id;
	}
	public void setCert_id(String cert_id) {
		this.cert_id = cert_id;
	}
	public String getCert_name() {
		return cert_name;
	}
	public void setCert_name(String cert_name) {
		this.cert_name = cert_name;
	}
	public Date getCert_date() {
		return cert_date;
	}
	public void setCert_date(Date cert_date) {
		this.cert_date = cert_date;
	}
	public String getCert_inst() {
		return cert_inst;
	}
	public void setCert_inst(String cert_inst) {
		this.cert_inst = cert_inst;
	}
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}

}
