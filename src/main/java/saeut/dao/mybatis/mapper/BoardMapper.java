package saeut.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import saeut.domain.Board;

public interface BoardMapper {

	List<Board> getAllBoard();
	List<Board> getBoardByUserId(String userid);
	List<Board> getBoardByPost_id(int post_id);
	void insertBoard(Board board);
	void modBoard(Board board);
	void removeBoard(int post_id);
}
