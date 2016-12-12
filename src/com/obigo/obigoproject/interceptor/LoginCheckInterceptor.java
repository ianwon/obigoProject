package com.obigo.obigoproject.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.obigo.obigoproject.log.service.LogService;
import com.obigo.obigoproject.vo.LogVO;

public class LoginCheckInterceptor implements HandlerInterceptor {
	@Autowired
	LogService logService;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean result = false;
		LogVO vo = new LogVO();
		vo.setBody("null");
		vo.setReturned("null");
		vo.setUrl(request.getRequestURI());
		logService.insertLog(vo);

		HttpSession session = request.getSession(false);
		
		if (session==null || session.getAttribute("LoginOK") == null) {
			response.sendRedirect("/obigoProject/login");
			return false;
		}

		String loginOK = (String) session.getAttribute("LoginOK");

		if ("".equals(loginOK)) {

			response.sendRedirect("/obigoProject/login");
			result = false;

		} else {

			result = true;

		}

		return result;
	}

}
