package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1084513641948068122L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("LogoutServlet doGet");
		HttpSession session = req.getSession();
		session.invalidate();
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
}
