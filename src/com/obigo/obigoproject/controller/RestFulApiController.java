package com.obigo.obigoproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obigo.obigoproject.api.service.ApiService;
import com.obigo.obigoproject.uservehicle.service.UserVehicleService;

@Controller
public class RestFulApiController {
	@Autowired
	ApiService apiService;

	@Autowired
	UserVehicleService userVehicleService;

	@RequestMapping("/api/carlist")
	@ResponseBody
	public String carlist(HttpServletRequest request) {
		String userId = request.getParameter("user_id");
		userVehicleService.getUserVehicleList(userId);
		
		
		return null;
	}

}
