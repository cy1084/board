package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class UserManagement extends HttpServlet {

	private static final long serialVersionUID = -8663805493416862483L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UserManagement 회원관리 페이지 이동 do Get");
		req.setCharacterEncoding("UTF-8");
		IUserDao dao = new UserDaoImpl();
		List<UserDto> userList = dao.getAllUser();
		
		
		
		
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("/WEB-INF/views/management.jsp").forward(req, resp);
		
		
	}
	
	
	
	
	
	
}
