package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class DuplicateServlet extends HttpServlet {

	private static final long serialVersionUID = 1738503178630638547L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DuplicateServlet 아이디 중복 확인 do GET");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String registId = req.getParameter("registId");
		log.info("전달 값 {}",registId);
		IUserDao dao = new UserDaoImpl();
		String id = dao.idDuplicate(registId);
		
		boolean idIsc = false;
		if(id==null) {
			idIsc = true;
		}
		
		req.setAttribute("registId", registId);
		req.setAttribute("idIsc", idIsc);
		req.getRequestDispatcher("/WEB-INF/views/duplicate.jsp").forward(req, resp);
		
		
	}
	
	
	
}
