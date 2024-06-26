package com.min.edu.ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class RegistUserServlet extends HttpServlet {

	private static final long serialVersionUID = -8447118235206769300L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("RegistUserServlet 회원 가입 doGet");
		
		req.getRequestDispatcher("/WEB-INF/views/regist.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("RegistUserServlet 회원 가입 doPost");
//		req.setCharacterEncoding("UTF-8");
//		String id = req.getParameter("registId");
//		String password = req.getParameter("registPassword");
//		String name = req.getParameter("registName");
//		String phone = req.getParameter("registPhone");

//		log.info("전달받은 값 \n{}\n{}\n{}\n{}",id,password,name,phone);
//		
//		IUserDao dao = new UserDaoImpl();
//		UserDto dto = new UserDto();
//		dto.setId(id);
//		dto.setPassword(password);
//		dto.setName(name);
//		dto.setPhone(phone);
//		
//		dao.registUser(dto);
		
		
		req.setCharacterEncoding("UTF-8");
		//절대경로 <- 이클립스에 저장
		String saveDirectory = "C:\\Eclipse_IDES\\eclipse_WEB\\workspace_test\\Board_PGR\\src\\main\\webapp\\uploads";
		
		log.info("상대경로 {}" , saveDirectory);
		
		File directory = new File(saveDirectory);
		
		
		
		//폴더 없을때
		if(!directory.exists()) {
			boolean create = directory.mkdirs();
			if(create) {
				log.info("디렉토리 생성 성공 {}", saveDirectory);
			} else {
				log.info("디렉토리 생성 실패");
			}
		}
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			FileItemIterator iterator = upload.getItemIterator(req);
			UserDto registDto = new UserDto();
			
			while (iterator.hasNext()) {
				FileItemStream item = iterator.next();
				
				if(item.isFormField()) {//파일이 아닐때
					String filedName = item.getFieldName();
					String filedValue = Streams.asString(item.openStream());
					
					if("registId".equals(filedName)) {
						registDto.setId(filedValue);
					} else if("registPassword".equals(filedName)) {
						registDto.setPassword(filedValue);
					} else if("registName".equals(filedName)) {
						registDto.setName(filedValue);
					} else if("registPhone".equals(filedName)) {
						registDto.setPhone(filedValue);
					}
					log.info("전달받은 가입 요청 값 {}" , registDto);
					
				} else if(!item.isFormField()) { //파일일때
					
					String origin_fileName = item.getName();
					
					if(origin_fileName != null && !origin_fileName.isEmpty()) {
						String stored_fileName = UUID.randomUUID().toString().replace("-", "") + origin_fileName.substring(origin_fileName.lastIndexOf("."));
						
						File uploadedFile = new File(saveDirectory, stored_fileName);
						
						InputStream inputStream = null;
						OutputStream outputStream = null;
						
						inputStream = item.openStream();
						outputStream = new FileOutputStream(uploadedFile);
						
						
						inputStream.transferTo(outputStream);
						
						registDto.setPhoto_storedname(stored_fileName);
						
						log.info("최종 입력 값 : {}", registDto);

					}
						
				} 
				
			}
			
			IUserDao dao = new UserDaoImpl();
			int n = dao.registUser(registDto);
			
			if(n > 0) {
				resp.setContentType("text/html; charset=UTF-8;");
				resp.getWriter().print("<script>alert('관리자의 승인 후 로그인 가능합니다.'); location.href='./loginServlet.do'</script>");
			}
			
		} catch (FileUploadException | IOException e) {
			e.printStackTrace();
		}	
			
	}

	
}
