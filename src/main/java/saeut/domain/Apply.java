package saeut.domain;

public class Apply {
	
	private int post_id; // (FK) - 게시물 아이디 
	private String id; // (FK) - 유저 아이디 
	private String introduce;
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	} 
	
}
