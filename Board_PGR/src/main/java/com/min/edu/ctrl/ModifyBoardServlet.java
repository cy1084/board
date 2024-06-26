package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.BoardDto;
import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ModifyBoardServlet extends HttpServlet {

	private static final long serialVersionUID = -5124008129292025705L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("ModifyBoardServlet doGet");
		
		req.setCharacterEncoding("UTF-8");
		String seq = req.getParameter("seq");
		
		IBoardDao dao = new BoardDaoImpl();
		BoardDto boardDto = dao.getDetailBoard(Integer.parseInt(seq));
		req.setAttribute("boardDto", boardDto);
		
		req.getRequestDispatcher("/WEB-INF/views/modify.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		log.info("ModifyBoardServlet 글 수정 완료 do Post");
		
		req.setCharacterEncoding("UTF-8");
		String content = req.getParameter("content");
		String seq = req.getParameter("seq");
		
		log.info("전달 받은 값 : {}, {}", content, seq);
		
		
		Map<String, Object> map = new HashMap<String, Object>(){{
			put("seq",seq);
			put("content",content);
			
		}};
		
		IBoardDao dao = new BoardDaoImpl();
		dao.modifyBoard(map);
		
		resp.sendRedirect("./detailBoard.do?seq="+seq);		
	}
	
	
}
