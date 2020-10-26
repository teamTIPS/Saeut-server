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
