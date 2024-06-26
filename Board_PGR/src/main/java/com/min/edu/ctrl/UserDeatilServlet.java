package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class UserDeatilServlet extends HttpServlet {

	private static final long serialVersionUID = -4543469973731559602L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UserDeatilServlet 회원 상세정보 조회 doGet");
		req.setCharacterEncoding("UTF-8");
		String id =req.getParameter("id");
		log.info("전달받은 값 : {}",id);
		
		IUserDao dao = new UserDaoImpl();
		UserDto userDto = dao.getDetailUser(id);
		req.setAttribute("userDto", userDto);
		req.getRequestDispatcher("/WEB-INF/views/userDetail.jsp").forward(req, resp);
		
		
	}
	
	
	
}
