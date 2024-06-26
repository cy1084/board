package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.BoardDto;

public interface IBoardDao {

	public int countBoard();
	
	public List<BoardDto> getAllBoard(Map<String, Object> map);
	
	public BoardDto getDetailBoard(int seq);
	
	public int insertBoard(BoardDto dto);
	
	public int modifyBoard(Map<String, Object> map);
	
	public int deleteBoard(List<Integer> list);
	
	
}
