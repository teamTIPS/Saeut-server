package saeut.domain;

import java.io.Serializable;
//import java.sql.Date; 둘중에 어떤건지 다시 체크하기 
import lombok.Data;

@Data
public class UserGroup implements Serializable {
	private int seq_id;
	private int post_id;
	private String captain;
	private int type;
	private String id;
}
