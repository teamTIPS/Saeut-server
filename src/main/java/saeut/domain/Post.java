package saeut.domain;

import java.io.Serializable;
import java.util.Date; //import java.util.sql일수도

/*
* Post Domain Class
* */
@SuppressWarnings("serial")
public class Post implements Serializable{

	private int post_id; //sequence
	private int account_id; // (FK) account 클래스의 id
	private String title; //게시물 제목
	private Date post_date; //게시글 추가한 날짜 
	private String contents; // 게시글 내용
	private Date start_date;
	private Date due_date;
	
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
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
	
	
}
