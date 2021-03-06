package com.ssafy.interceptor;

import javax.servlet.http.*;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssafy.sharehouse.dto.User;

@Component
public class ConfirmInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User memberDto = (User) session.getAttribute("userinfo");
		if(memberDto == null) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		return true;
	}

	
	
}
