package saeut.domain;

import java.io.Serializable;
//import java.sql.Date; 둘중에 어떤건지 다시 체크하기 
import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * Account Domain Class
 * */
@SuppressWarnings("serial")
public class UserEssential implements Serializable {

	/* Private Fields */
	@NotBlank
	@Email
    private String id;
    private String password;
    private String name;
    private int phone;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birth;
    private int gender;
    private boolean perm1;
    
	/* JavaBeans Properties */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public boolean isPerm1() {
		return perm1;
	}
	public void setPerm1(boolean perm1) {
		this.perm1 = perm1;
	}
	
	@Override
	public String toString() {
		return "UserEssential [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", birth="
				+ birth + ", gender=" + gender + ", perm1=" + perm1 + "]";
	}

}
