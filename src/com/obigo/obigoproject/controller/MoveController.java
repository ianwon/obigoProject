package com.obigo.obigoproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
import com.obigo.obigoproject.vo.ApiVO;
import com.obigo.obigoproject.vo.BundleVO;
import com.obigo.obigoproject.vo.LogVO;
import com.obigo.obigoproject.vo.PushMessageVO;
import com.obigo.obigoproject.vo.ResourceVO;
import com.obigo.obigoproject.vo.UserRequestVO;
import com.obigo.obigoproject.vo.UserVehicleVO;
import com.obigo.obigoproject.vo.UsersVO;
import com.obigo.obigoproject.vo.VehicleVO;

@Controller
public class MoveController {
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
	 * DashBoard로 이동
	 * 
	 * @return 메인 페이지
	 */
	@RequestMapping("/main")
	public String moveDashBoard() {

		return "/jsp/header/main";
	}

	/**
	 * 회원가입 페이지로 이동
	 * 
	 * @return 회원 가입 페이지
	 */
	@RequestMapping("/registration")
	public String moveRegistration() {

		return "/jsp/registration";
	}

	/**
	 * 헤더 USERS클릭시 이동
	 * 
	 * @return 유저 관리 페이지
	 */
	@RequestMapping("/usermanagement")
	public String moveUser(Model model) {

		List<UsersVO> list = userService.getUserList();
		model.addAttribute("userList", list);
		return "/jsp/user";
	}

	/**
	 * 헤더 ADMIN클릭시 이동
	 * 
	 * @return 관리자 관리 페이지
	 */
	@RequestMapping("/adminmanagement")
	public String moveAdmin(Model model) {

		List<UsersVO> list = userService.getAdminList();
		model.addAttribute("adminList", list);
		return "/jsp/admin";
	}

	/**
	 * 로그인 실패시 다시 로그인페이지를 띄어줌
	 * 
	 * return 로그인 페이지
	 */
	@RequestMapping("/login")
	public String moveLogin() {
		return "/jsp/login";
	}

	/**
	 * 헤더 USER REQUEST클릭시 이동
	 * 
	 * @return 유저 요청 관리 페이지
	 */
	@RequestMapping("/userrequest")
	public String moveUserRequest(Model model) {

		List<UserRequestVO> list = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", list);
		return "/jsp/userrequest";
	}

	/**
	 * 헤더 VEHICLE클릭시 이동
	 * 
	 * @return 차량 관리 페이지
	 */
	@RequestMapping("/vehicle")
	public String moveVehicle(Model model) {

		List<VehicleVO> list = vehicleService.getVehicleList();
		model.addAttribute("vehicleList", list);
		return "/jsp/vehicle";
	}

	/**
	 * 헤더 BUNDLE클릭시 이동
	 * 
	 * @return 번들 관리 페이지
	 */
	@RequestMapping("/bundle")
	public String moveBundle(Model model) {
		String version = bundleVersionService.getBundleVersion();
		List<BundleVO> list = bundleService.getBundleList();
		model.addAttribute("bundleList", list);
		model.addAttribute("bundleVersion", version);
		return "/jsp/bundle";
	}

	/**
	 * 헤더 RESOURCE클릭시 이동
	 * 
	 * @return 리소스 관리 페이지
	 */
	@RequestMapping("/resource")
	public String moveResource(Model model, String bundleKey) {
		List<BundleVO> bundlelist = bundleService.getBundleList();
		model.addAttribute("bundleList", bundlelist);
		if (bundleKey == null || bundleKey == "") {
			List<ResourceVO> resourcelist = resourceService.getResourceList();
			model.addAttribute("resourceList", resourcelist);
		} else {
			List<ResourceVO> resourcelist = resourceService.getResourceListBybundleKey(bundleKey);
			model.addAttribute("resourceList", resourcelist);
		}

		return "/jsp/resource";

	}

	/**
	 * 헤더 RESTFUL API 클릭시 이동
	 * 
	 * @return API 관리 페이지
	 */
	@RequestMapping("/api")
	public String moveApi(Model model) {

		List<ApiVO> list = apiService.getApiList();
		model.addAttribute("apiList", list);
		return "/jsp/api";
	}

	/**
	 * 헤더 PUSH클릭시 이동
	 * 
	 * @return 푸시메시지 관리 페이지
	 */
	@RequestMapping("/pushmessage")
	public String movePushMessage(Model model) {

		List<PushMessageVO> list = pushMessageService.getPushMessageList();
		model.addAttribute("pushMessageList", list);
		return "/jsp/pushmessage";
	}

	/**
	 * 헤더 Send Message클릭시 이동
	 * 
	 * @return 푸시메시지 전송 페이지
	 */
	@RequestMapping("/sendmessage")
	public String moveSendMessage(Model model) {
		model.addAttribute("modelList", vehicleService.getVehicleList());
		model.addAttribute("locationList", userVehicleService.getLocation());
		model.addAttribute("messagecategory", messageCategoryService.getMessageCategoryList());
		return "/jsp/sendmessage";
	}

	/**
	 * 헤더 LOGS클릭시 이동
	 * 
	 * @return 로그 관리 페이지
	 */
	@RequestMapping("/log")
	public String moveLog(Model model) {

		List<LogVO> list = logService.getLogList();
		model.addAttribute("logList", list);
		return "/jsp/log";
	}

	/**
	 * User 선택시 userVehicle 이동
	 * 
	 * @return 유저 차량 관리 페이지
	 */
	@RequestMapping(value = "/userVehicle")
	public String moveUserVehicle(@RequestParam("userId") String userId, Model model, HttpServletResponse response) {
		////////////// userVehicleList, vehicleList 초기화///////////////////////////
		List<UserVehicleVO> userVehicleList = userVehicleService.getUserVehicleList(userId);
		model.addAttribute("userVehicleList", userVehicleList);
		List<VehicleVO> vehicleList = new ArrayList<>();
		for (int i = 0; i < userVehicleList.size(); i++) {
			vehicleList.add(vehicleService.getVehicle(userVehicleList.get(i).getModelCode()));
		}

		model.addAttribute("vehicleList", vehicleList);

		return "/jsp/uservehicle";

	}

	/////////////////// 잠시 생각/////////////////////////////////
	/**
	 * 헤더 ANALYTICS클릭시 이동
	 * 
	 * @return 통계 관리 페이지
	 */
	@RequestMapping("/analytics")
	public String moveAnalytics(Model model) {
		return null;
	}

}
