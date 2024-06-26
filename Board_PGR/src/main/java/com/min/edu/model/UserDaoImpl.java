package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.BoardDto;
import com.min.edu.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDaoImpl implements IUserDao {

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.UserDaoImpl.";
	
	@Override
	public UserDto getLogin(Map<String, Object> map) {
		log.info("getLogin 로그인 전달받은 값 : {}", map);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getLogin", map);
	}

	@Override
	public int registUser(UserDto dto) {
		log.info("registUser 회원가입 전달 받은 값 : {}, dto");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"registUser",dto);
	}

	@Override
	public List<BoardDto> getMyBoard(Map<String, Object> map) {
		log.info("getMyBoard 내가 쓴 글 조회 전달 받은 값 : {}, map ");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getMyBoard",map);
	}

	@Override
	public List<UserDto> getAllUser() {
		log.info("getAllUser 전체 회원 조회");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getAllUser");
	}

	@Override
	public int deleteUser(List<String> ids) {
		log.info("deleteUser 회원 삭제 전달 받은 값 : {}, id ");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"deleteUser",ids);
	}

	@Override
	public int approvalUser(List<String> ids) {
		log.info("approvalUser 가입 승인 전달 받은 값 : {}, id ");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"approvalUser",ids);
	}

	@Override
	public int refusalUser(List<String> ids) {
		log.info("refusalUser 가입 거절 전달 받은 값 : {}, id ");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"refusalUser",ids);
	}

	@Override
	public String idDuplicate(String id) {
		log.info("idDuplicate 아이디 중복확인 전달 값 : {}, id ");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"idDuplicate",id);
	}

	@Override
	public int countMyBoard(String id) {
		log.info("countMyBoard 내가 쓴 글 개수 : {}, id ");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"countMyBoard",id);
	}

	@Override
	public UserDto getDetailUser(String id) {
		log.info("getDetailUser 상세 정보 조회 : {}, id ");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getDetailUser", id);
	}

}
