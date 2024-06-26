package com.min.edu.ctrl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class RefusalUserServlet extends HttpServlet {

	private static final long serialVersionUID = -2944714453128830515L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("RefusalUserServlet 회원가입 거절 doGet");
		
		String[] ids = req.getParameterValues("UserCheck");
		List<String> refusalIds = Arrays.asList(ids);
		log.info("화면에서 요청 된 값 ids {}",refusalIds);
		
		IUserDao dao = new UserDaoImpl();
		dao.refusalUser(refusalIds);		
		resp.sendRedirect("./userManagement.do");
	}
}
