package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.BoardDto;
import com.min.edu.dto.UserDto;

public interface IUserDao {

	// 사용자 기능
	public UserDto getLogin(Map<String, Object> map);
	
	public int registUser(UserDto dto);
	
	public List<BoardDto> getMyBoard(Map<String, Object> map);
	
	public int countMyBoard(String id);
	
	public String idDuplicate(String id);
	
	
	
	
	// 관리자 기능
	public List<UserDto> getAllUser();
	
	public UserDto getDetailUser(String id);
	
	public int deleteUser(List<String> id);
	
	public int approvalUser(List<String> id);
	
	public int refusalUser(List<String> id);
	
	
	
	
}
