package com.min.edu.comm;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.min.edu.dto.UserDto;

public class AccessFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = -6579804467487173578L;
	private List<String> excludeURL;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		
		System.out.println("필터 생성");
		String exclude = config.getInitParameter("excludeURL");
		excludeURL = Arrays.asList(exclude.split(","));
		System.out.println("제외 주소:" + excludeURL);

		
	}

	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		String path = request.getServletPath();
		
		HttpSession session = request.getSession();
		UserDto loginDto = (UserDto)session.getAttribute("loginDto");

		if(excludeURL.contains(path)) { // 제외주소포함
			chain.doFilter(req, res);
			
		} else {
			
			if(loginDto == null) {
				//로그인세션없을때
				req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
				
			} else {
				//세션있을때
				chain.doFilter(req, res);
				
			}
		}
		
	}
	@Override
	public void destroy() {
		System.out.println("필터 소멸");
	}
	
	
	
}
