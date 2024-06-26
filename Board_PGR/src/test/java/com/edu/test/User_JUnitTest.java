package com.edu.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.dto.BoardDto;
import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class User_JUnitTest {

	private IUserDao dao;
	
	public User_JUnitTest() {
		dao = new UserDaoImpl();
	}
	
//	@Test
	public void test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "user");
		map.put("password", "user");
		dao.getLogin(map);
		assertNotNull(map);
	}
	
//	@Test
	public void regist_Test() {
		UserDto dto = new UserDto();
		dto.setId("TESTID");
		dto.setPassword("TESTID");
		dto.setName("TEST");
		dto.setPhone("01012557777");
		int n = dao.registUser(dto);
		assertNotEquals(0, n);
	}
	
//	@Test
	public void getMyBoard_Test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "user");
		map.put("first", "1");
		map.put("last", "5");
		List<BoardDto> lists = dao.getMyBoard(map);
		assertNotEquals(0, lists.size());
	}
	
//	@Test
	public void getAllUser_Test() {
		List<UserDto> lists = dao.getAllUser();
		assertNotEquals(0, lists.size());
	}
	
//	@Test
	public void deleteUser_Test() {
		String[] str = {"TESTID", "user"};
		List<String> str2 = Arrays.asList(str);
		int n = dao.deleteUser(str2);
		assertNotEquals(0, n);
	}

//	@Test
	public void approvalUser_Test() {
		String[] str = {"TESTID", "user"};
		List<String> str2 = Arrays.asList(str);
		int n = dao.approvalUser(str2);
		assertNotEquals(0, n);
	}
	
//	@Test
	public void refusalUser_Test() {
		String[] str = {"TESTID", "user"};
		List<String> str2 = Arrays.asList(str);
		int n = dao.refusalUser(str2);
		assertNotEquals(0, n);
	}
	
//	@Test
	public void countMyBoard_Test() {
 		int n = dao.countMyBoard("user");
 		assertNotEquals(0, n);
	}
	
	@Test
	public void getDetailUser_Test() {
		UserDto dto = dao.getDetailUser("user");
		assertNotNull(dto);
	}
	
	
}
