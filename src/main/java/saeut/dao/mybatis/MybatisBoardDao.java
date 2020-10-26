package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import saeut.dao.BoardDao;
import saeut.dao.mybatis.mapper.BoardMapper;
import saeut.domain.Board;

@Repository
public class MybatisBoardDao implements BoardDao{

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<Board> getAllBoard() {
		// TODO Auto-generated method stub
		return boardMapper.getAllBoard();
	}

	@Override
	public List<Board> getBoardByUserId(String userid) {
		// TODO Auto-generated method stub
		return boardMapper.getBoardByUserId(userid);
	}

	@Override
	public List<Board> getBoardByPost_id(int post_id) {
		// TODO Auto-generated method stub
		return boardMapper.getBoardByPost_id(post_id);
	}

	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		boardMapper.insertBoard(board);
	}

	@Override
	public void modBoard(Board board) {
		// TODO Auto-generated method stub
		boardMapper.modBoard(board);
	}

	@Override
	public void removeBoard(int post_id) {
		// TODO Auto-generated method stub
		boardMapper.removeBoard(post_id);
	}
	

	
}
