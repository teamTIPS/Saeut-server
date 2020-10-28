package saeut.domain;

import java.io.Serializable;
//import java.sql.Date; 둘중에 어떤건지 다시 체크하기 
import lombok.Data;

@Data
public class Tag implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Tag() {}
	public Tag(int post_id, String tag_name) {
		this.post_id = post_id;
		this.tag_name = tag_name;
	}
	private int post_id;
	private String tag_name;
}
