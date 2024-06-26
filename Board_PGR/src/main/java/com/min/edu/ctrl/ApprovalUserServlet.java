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
public class ApprovalUserServlet extends HttpServlet {

	private static final long serialVersionUID = 4502117281554796100L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("ApprovalUserServlet 회원가입 승인 doGet");
		
		String[] ids = req.getParameterValues("UserCheck");
		List<String> approvalIds = Arrays.asList(ids);
		log.info("화면에서 요청 된 값 ids {}",approvalIds);
		
		IUserDao dao = new UserDaoImpl();
		dao.approvalUser(approvalIds);		
		resp.sendRedirect("./userManagement.do");
		
	}
	
}
