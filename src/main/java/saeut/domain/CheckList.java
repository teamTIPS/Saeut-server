package saeut.domain;

import java.io.Serializable;

/*
* CheckList Domain Class
* */
@SuppressWarnings("serial")
public class CheckList implements Serializable{
	
	private int check_type;
	private String name;
	private boolean checked;
	public int getCheck_type() {
		return check_type;
	}
	public void setCheck_type(int check_type) {
		this.check_type = check_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}
