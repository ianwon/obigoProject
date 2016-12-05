package com.obigo.obigoproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obigo.obigoproject.api.service.ApiService;
import com.obigo.obigoproject.bundle.service.BundleService;
import com.obigo.obigoproject.bundleversion.service.BundleVersionService;
import com.obigo.obigoproject.log.service.LogService;
import com.obigo.obigoproject.messagecategory.service.MessageCategoryService;
import com.obigo.obigoproject.pushmessage.service.PushMessageService;
import com.obigo.obigoproject.resource.service.ResourceService;
import com.obigo.obigoproject.user.service.UserService;
import com.obigo.obigoproject.usermessage.service.UserMessageService;
import com.obigo.obigoproject.userrequest.service.UserRequestService;
import com.obigo.obigoproject.uservehicle.service.UserVehicleService;
import com.obigo.obigoproject.vehicle.service.VehicleService;

import net.sf.json.JSONObject;

@Controller
public class RestFulApiController {
	@Autowired
	ApiService apiService;
	@Autowired
	BundleService bundleService;
	@Autowired
	BundleVersionService bundleVersionService;
	@Autowired
	LogService logService;
	@Autowired
	MessageCategoryService messageCategoryService;
	@Autowired
	PushMessageService pushMessageService;
	@Autowired
	ResourceService resourceService;
	@Autowired
	UserService userService;
	@Autowired
	UserMessageService userMessageService;
	@Autowired
	UserRequestService userRequestService;
	@Autowired
	UserVehicleService userVehicleService;
	@Autowired
	VehicleService vehicleService;

	/**
	 * 메인 페이지로 이동
	 * 
	 * @return 메인 페이지
	 */
	@RequestMapping(value = "/api/login/{id}/{password}", method = { RequestMethod.GET })
	@ResponseBody
	public String moveMain(@PathVariable String id, @PathVariable String password) {
		JSONObject jobj = new JSONObject();
		if (userService.idCheck(id)) {
			if (userService.getUser(id).getPassword().equals(password)) {
				jobj.put("flag", true);
				jobj.put("userVehicle", userVehicleService.getUserVehicleList(id));
			} else
				jobj.put("flag", false);
		} else {
			jobj.put("flag", false);
		}

		return jobj.toString();
	}

	@RequestMapping("/api/carlist")
	@ResponseBody
	public String carlist(HttpServletRequest request) {
		String userId = request.getParameter("user_id");
		userVehicleService.getUserVehicleList(userId);

		return null;
	}

}
