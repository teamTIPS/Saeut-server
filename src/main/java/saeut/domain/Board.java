package saeut.domain;

import java.io.Serializable;
import java.util.Date; //import java.sql.Date; 둘중에 어떤건지 다시 체크하기 
import lombok.Data;

@Data
public class Board implements Serializable {
	private int post_id;
	private String id;
	private Date post_date;
	private String contents;
	private int cnt_like;
	private int cnt_reply;
	// Join하여 함께 가져오는 사용자 정보 항목
	private int rank;
	private String nickname;
	private String address1;
}
