package com.min.edu.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class DeleteBoardServlet extends HttpServlet {

	private static final long serialVersionUID = 3231474244130530844L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DeleteBoardServlet 삭제 doGet 요청");
		
		String seq = req.getParameter("seq");
		
		log.info("전달받은 값 : {}", seq);	
		List<Integer> singleDelete = new ArrayList<Integer>();

		IBoardDao dao = new BoardDaoImpl();
			singleDelete.add(Integer.parseInt(seq));
			dao.deleteBoard(singleDelete);
			resp.sendRedirect("./boardMain.do");
			

		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DeleteBoardServlet 삭제 doPost 요청");
		
		String[] seqs = req.getParameterValues("check");
		List<String> seqList = Arrays.asList(seqs);
		log.info("전달받은 값 : {}", seqList);	
		List<Integer> multiDelete = new ArrayList<Integer>();
		
		IBoardDao dao = new BoardDaoImpl();
		for(String str : seqList) {
			multiDelete.add(Integer.parseInt(str));
		}
		
		dao.deleteBoard(multiDelete);
		resp.sendRedirect("./boardMain.do");
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
