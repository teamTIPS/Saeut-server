package saeut.domain;

import java.io.Serializable;
import java.util.Date; //import java.util.sql일수도

import com.fasterxml.jackson.annotation.JsonFormat;

/*
* Post Domain Class
* */
@SuppressWarnings("serial")
public class Post implements Serializable{

	private int post_id; //sequence
	private String id; // (FK) account 클래스의 id
	private String title; //게시물 제목
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date post_date; //게시글 추가한 날짜
	private String post_age; // 선호연령
	private String post_schedule; // 선호시간대
	private String post_gender; // 선호성별
	private String contents; // 게시글 내용
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date start_date; // 돌봄 요청 시작 날짜 -> 모바일 캘린더
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date due_date; // 돌봄 요청 마지막 날짜  -> 모바일 캘린더 
	private int recruit_status; // 모집 중(0)/모집 마감(1)/완료(2)
	private int type; // 장애인(0) / 아동(1) / 노인(2)
	private int payment; // 요청자가 서비스에 지불하는 시급
	private int wage; // 제공자가 받는 시급
	private int limit_supply; // 최대 돌봄제공자 수
	private int limit_demand; // 최대 돌봄요청자 수
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}	
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getPost_age() {
		return post_age;
	}
	public void setPost_age(String post_age) {
		this.post_age = post_age;
	}
	public String getPost_schedule() {
		return post_schedule;
	}
	public void setPost_schedule(String post_schedule) {
		this.post_schedule = post_schedule;
	}
	public String getPost_gender() {
		return post_gender;
	}
	public void setPost_gender(String post_gender) {
		this.post_gender = post_gender;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public int getRecruit_status() {
		return recruit_status;
	}
	public void setRecruit_status(int recruit_status) {
		this.recruit_status = recruit_status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public int getLimit_supply() {
		return limit_supply;
	}
	public void setLimit_supply(int limit_supply) {
		this.limit_supply = limit_supply;
	}
	public int getLimit_demand() {
		return limit_demand;
	}
	public void setLimit_demand(int limit_demand) {
		this.limit_demand = limit_demand;
	}
	
}
