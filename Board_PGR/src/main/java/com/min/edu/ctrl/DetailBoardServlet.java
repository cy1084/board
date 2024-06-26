package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.BoardDto;
import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class DetailBoardServlet extends HttpServlet {

	private static final long serialVersionUID = 6019366888148739301L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DetailBoard doGet 요청 ");
		
		String seq = req.getParameter("seq");
		String num = req.getParameter("num");
		log.info("전달받은 값 : {}, {}" , seq,num);
		
		IBoardDao dao = new BoardDaoImpl();
		BoardDto boardDto = dao.getDetailBoard(Integer.parseInt(seq));
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("num", num);
		req.setAttribute("boardDto", boardDto);		
		req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req, resp);
		
		
	}
	
	
	
}
