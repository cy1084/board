package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.BoardDto;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class BoardDaoImpl implements IBoardDao {

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.BoardDaoImpl.";
	
	@Override
	public int countBoard() {
		log.info("countBoard 전체 게시글 개수");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"countBoard");
	}

	@Override
	public List<BoardDto> getAllBoard(Map<String, Object> map) {
		log.info("getAllBoard 전체 게시글 조회");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getAllBoard",map);
	}

	@Override
	public BoardDto getDetailBoard(int seq) {
		log.info("getDetailBoard 상세 게시글 조회 전달 값: {}", seq);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getDetailBoard",seq);
	}

	@Override
	public int insertBoard(BoardDto dto) {
		log.info("insertBoard 게시글 등록 전달 값: {}" ,dto);
		SqlSession session = manager.openSession(true);
		return session.insert(NS+"insertBoard",dto);
	}

	@Override
	public int modifyBoard(Map<String, Object> map) {
		log.info("modifyBoard 게시글 수정 전달 값: {}", map);
		SqlSession session = manager.openSession(true);
		return session.update(NS+"modifyBoard", map);
	}

	@Override
	public int deleteBoard(List<Integer> list) {
		log.info("deleteBoard 게시글 (다중)삭제 전달 값: {}", list);
		SqlSession session = manager.openSession(true);
		return session.delete(NS+"deleteBoard",list);
	}

}
