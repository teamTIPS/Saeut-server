package saeut.domain;

import java.io.Serializable;
import java.util.Date;

/*
* Timetable Domain Class
* */
@SuppressWarnings("serial")
public class Timetable  implements Serializable{

	private int time_id; // (PK) sequence id
	private int id; // (FK) account table의 유저 아이디 
	private Date day; // 요일
	private Date start_time; // 하루 중 시작 시간 
	private Date due_time; // 하루 중 끝나는 시간 
	
	public int getTime_id() {
		return time_id;
	}
	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getDue_time() {
		return due_time;
	}
	public void setDue_time(Date due_time) {
		this.due_time = due_time;
	}
	
}
