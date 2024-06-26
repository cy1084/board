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
public class DeleteUserServlet extends HttpServlet {

	private static final long serialVersionUID = -3262745857730736989L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DeleteUserServlet 회원 삭제 doGet");
		
		String[] ids = req.getParameterValues("UserCheck");
		List<String> deleteIds = Arrays.asList(ids);
		log.info("화면에서 요청 된 값 ids {}",deleteIds);
		
		IUserDao dao = new UserDaoImpl();
		dao.deleteUser(deleteIds);		
		resp.sendRedirect("./userManagement.do");
	}
}
