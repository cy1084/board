package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.dto.BoardDto;
import com.min.edu.dto.PageDto;
import com.min.edu.dto.UserDto;
import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class GetMyBoardServlet extends HttpServlet {

	private static final long serialVersionUID = -6107859652379725813L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("GetMyBoardServlet 내글 조회");
		
		IUserDao dao = new UserDaoImpl();
		
		String page = req.getParameter("page");
		HttpSession session = req.getSession();
		UserDto loginDto = (UserDto)session.getAttribute("loginDto");
		
		
		if(page == null) {	//첫페이지로 이동
			page = "1";
		}
		
		int selectPage = Integer.parseInt(page);
		
		PageDto p = new PageDto();
		p.setTotalCount(dao.countMyBoard(loginDto.getId())); 
		p.setCountList(5); 
		p.setCountPage(5); 
		p.setTotalPage(p.getTotalCount());
		p.setPage(selectPage);
		p.setStagePage(selectPage);
		p.setEndPage(p.getCountPage());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", loginDto.getId());
		map.put("first", p.getPage()*p.getCountList() - (p.getCountList() - 1));
		map.put("last", p.getPage()*p.getCountList());
		
		List<BoardDto> myBoardList = dao.getMyBoard(map);
		
		req.setAttribute("page", p);
		req.setAttribute("myBoardList", myBoardList);
		req.getRequestDispatcher("/WEB-INF/views/myBoardList.jsp").forward(req, resp);
		
		
	}
	
	
	
	
	
	
}
