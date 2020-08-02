package saeut.domain;

import java.io.Serializable;

/*
* Supply Domain Class
* */
@SuppressWarnings("serial")
public class Supply implements Serializable{
	
	private int rank;
	private float score;
	private String description;
	private int type; // (FK)
	private String id; // (FK) - PK
	
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
