package saeut.domain;

public class Apply {
	
	private int post_id; // (FK) - 게시물 아이디 
	private String id; // (FK) - 유저 아이디 
	private String introduce; // 자기소개
	private int type; // 제공자(0), 요청자(1) 타입
	
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
