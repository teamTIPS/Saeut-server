package saeut.domain;

import java.io.Serializable;
import java.util.Date;

/*
* Demand Domain Class
* */
@SuppressWarnings("serial")
public class UserAdditional implements Serializable{
	
	private int ranks;
	private float score;
	private String description;
	private Date birth;
	private String zipcode;
	private String address1;
	private String address2;
	private String id; // (FK) - PK
	
	public int getRank() {
		return ranks;
	}
	public void setRank(int rank) {
		this.ranks = rank;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRanks() {
		return ranks;
	}
	public void setRanks(int ranks) {
		this.ranks = ranks;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
