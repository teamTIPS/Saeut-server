package saeut.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.Tag;

public interface TagMapper {

	//모든 태그 가져오기
	List<Tag> getAllTag();
	// Post_id로 태그 가져오기
	List<Tag> getTagByPostID(int post_id);
	// 태그 추가
	void insertTag(Tag tag);
	// post_id로 태그 제거
	void removeTag(int post_id);
}
