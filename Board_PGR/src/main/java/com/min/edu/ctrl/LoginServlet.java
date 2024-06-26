package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 3828164570372890792L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("LoginServlet doGet 요청");
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		log.info("전달받은 값: {},{}",id,password);
		IUserDao dao = new UserDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);
		UserDto loginDto = dao.getLogin(map);
		
		HttpSession session = req.getSession();
		
		
		if(loginDto == null) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("<script>alert('존재하지 않는 정보입니다.'); location.href='./'</script>");
		} else {
			session.setAttribute("loginDto", loginDto);
			resp.sendRedirect("./boardMain.do");
		}
		
	}
	
	
	
}
