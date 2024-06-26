package com.edu.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.dto.BoardDto;
import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;

public class Board_JUnitTest {

	private IBoardDao dao;
	
	public Board_JUnitTest() {
		dao = new BoardDaoImpl();
	}
	
//	@Test
	public void countBoard_JUnitTest() {
		int n = dao.countBoard();
		assertEquals(1, n);
	}
	
//	@Test
	public void getAllboard_JUnitTest() {
		Map<String, Object> map = new HashMap<String, Object>();
 		List<BoardDto> lists = dao.getAllBoard(map);
		assertNotEquals(0, lists.size());
	}
	
//	@Test
	public void getDetailBoard_JUnitTest() {
		BoardDto dto = dao.getDetailBoard(1);
		assertNotNull(dto);
	}
	
	@Test
	public void insertBoard_JUnitTest() {
		BoardDto dto = new BoardDto();
		dto.setId("user"); 
		dto.setTitle("제목");
		dto.setContent("내용");
		int n = dao.insertBoard(dto);
		assertEquals(1, n);
	}
	
//	@Test
	public void modifyBoard_JUnitTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "수정된 내용");
		map.put("seq", 1);
		int n = dao.modifyBoard(map);
		assertEquals(1, n);
	}
	
	@Test
	public void deleteBoard_JUnitTest() {
		List<Integer> lists = new ArrayList<Integer>();
		lists.add(1);
		lists.add(2);
		lists.add(3);
		int n = dao.deleteBoard(lists);
		assertNotEquals(0, n);
	}
	
	
	
	
	
	
}
