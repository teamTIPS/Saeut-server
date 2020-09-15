package saeut.domain;

import java.io.Serializable;
import java.util.Date;

/*
* Demand Domain Class
* */
@SuppressWarnings("serial")
public class UserAdditional implements Serializable{
	
	private String id; // (FK) - PK
	private String nickname; 
	private String pic;
	private int rank;
	private float score;
	private String description;
	private String zipcode;
	private String address1;
	private String address2;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
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
	
	@Override
	public String toString() {
		return "UserAdditional [id=" + id + ", nickname=" + nickname + ", pic=" + pic + ", rank=" + rank + ", score="
				+ score + ", description=" + description + ", zipcode=" + zipcode + ", address1=" + address1
				+ ", address2=" + address2 + "]";
	}
	
}
