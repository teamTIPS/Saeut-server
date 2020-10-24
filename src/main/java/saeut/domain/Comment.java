package saeut.domain;

import java.io.Serializable;
//import java.sql.Date; 둘중에 어떤건지 다시 체크하기 
import java.util.Date;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
/*
* Certificate Domain Class
* */
@SuppressWarnings("serial")
@Data
public class Comment implements Serializable {
	private int comment_id; // 댓글 번호
	private int post_id; // 게시글 번호
	private String id; // 작성자 ID
	private String contents; // 댓글 내용
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date write_time; // 작성 시간
}
