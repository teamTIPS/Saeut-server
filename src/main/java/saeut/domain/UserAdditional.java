package saeut.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
/*
* Demand Domain Class
* */
@SuppressWarnings("serial")
@Data
public class UserAdditional implements Serializable{
	
	public UserAdditional() {}
	public UserAdditional(String id, String nickname, String pic, String description, String zipcode, String address1,
			String address2, String add_latitude, String add_longitude, String introduce, double grade) {
		this.id = id;
		this.nickname = nickname;
		this.pic = pic;
		this.description = description;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
		this.add_latitude = add_latitude;
		this.add_longitude = add_longitude;
		this.introduce = introduce;
		this.grade = grade;
	}
	private String id; // (FK) - PK
	private String nickname; 
	private String pic;
	private String description;
	private String zipcode;
	private String address1;
	private String address2;
	private String add_latitude;
	private String add_longitude;
	private String introduce;
	private double grade;
}
