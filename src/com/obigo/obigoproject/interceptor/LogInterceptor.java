package com.obigo.obigoproject.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.obigo.obigoproject.log.service.LogService;
import com.obigo.obigoproject.vo.LogVO;

public class LogInterceptor implements HandlerInterceptor {
	@Autowired
	LogService logService;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3) throws Exception {
//		LogVO vo = new LogVO();
//		vo.setUrl(request.getRequestURI());
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
