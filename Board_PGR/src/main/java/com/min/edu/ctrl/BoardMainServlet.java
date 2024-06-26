package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.BoardDto;
import com.min.edu.dto.PageDto;
import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class BoardMainServlet extends HttpServlet {

	private static final long serialVersionUID = -3334901054427839295L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		log.info("BoardListServlet GET : 모든 게시글 조회");
		IBoardDao dao = new BoardDaoImpl();
		
		String page = req.getParameter("page");
		
		if(page == null) {
			page = "1";
		}
		
		//뿌려질 페이지
		int selectPage = Integer.parseInt(page);
		
		PageDto p = new PageDto();
		p.setTotalCount(dao.countBoard()); // 전체글의 row 갯수
		p.setCountList(5); // 화면 한 페이지에 포함되어있는 row의 갯수
		p.setCountPage(5); // 페이지 그룹
		p.setTotalPage(p.getTotalCount());
		p.setPage(selectPage);
		p.setStagePage(selectPage);
		p.setEndPage(p.getCountPage());
		
		
		// 전체가 아닌 특정 범위를 param으로 전송해줘야함.
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first", p.getPage()*p.getCountList() - (p.getCountList() - 1));
		// 1page =  (1 * 5) - (5-1) : 1
		// 3page = (3*5) - (5-1) : 11
		map.put("last", p.getPage()*p.getCountList()); // 1*5
		
		
		List<BoardDto> boardList = dao.getAllBoard(map);
		req.setAttribute("page", p);
		req.setAttribute("boardList", boardList);
		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);

		
	}
	
	
}
