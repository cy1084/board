package com.min.edu.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.dto.BoardDto;
import com.min.edu.dto.UserDto;
import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class InsertBoardServlet extends HttpServlet {

	private static final long serialVersionUID = -6079506230026092331L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("InsertBoardServlet doGet 요청");
		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);

	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("InsertBoardServlet doPost 요청");
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		HttpSession session = req.getSession();
		UserDto loginDto = (UserDto)session.getAttribute("loginDto");
		
		BoardDto boardDto = new BoardDto();
		
		if(loginDto != null) {
			
			boardDto.setId(loginDto.getId());
			boardDto.setTitle(title);
			boardDto.setContent(content);
			IBoardDao dao = new BoardDaoImpl();
			dao.insertBoard(boardDto);
			
			log.info(" select key 값 확인 {}", boardDto);
			
			resp.sendRedirect("./detailBoard.do?seq="+ boardDto.getSeq());
		} else {
			
			resp.getWriter().print("<script>alert('잘못된 접근입니다.'); location.href='./'</script>");
			
		}
		
		
//		dao.insertBoard(map);
	

		///inserBoard dto로 수정하기. >> selectKEY
		///inserBoard dto로 수정하기. >> selectKEY
		///inserBoard dto로 수정하기. >> selectKEY
		///inserBoard dto로 수정하기. >> selectKEY
		///inserBoard dto로 수정하기. >> selectKEY
		///inserBoard dto로 수정하기. >> selectKEY
		///inserBoard dto로 수정하기. >> selectKEY
		
		
		
		
		
	}
	
	
	
	
}
