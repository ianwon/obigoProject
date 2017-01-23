package com.obigo.obigoproject.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.obigo.obigoproject.api.service.ApiService;
import com.obigo.obigoproject.bundle.service.BundleService;
import com.obigo.obigoproject.bundleversion.service.BundleVersionService;
import com.obigo.obigoproject.log.service.LogService;
import com.obigo.obigoproject.messagecategory.service.MessageCategoryService;
import com.obigo.obigoproject.pushmessage.service.PushMessageService;
import com.obigo.obigoproject.user.service.UserService;
import com.obigo.obigoproject.usermessage.service.UserMessageService;
import com.obigo.obigoproject.userrequest.service.UserRequestService;
import com.obigo.obigoproject.uservehicle.service.UserVehicleService;
import com.obigo.obigoproject.vehicle.service.VehicleService;
import com.obigo.obigoproject.vo.ApiVO;
import com.obigo.obigoproject.vo.BundleVO;
import com.obigo.obigoproject.vo.LogVO;
import com.obigo.obigoproject.vo.PushMessageVO;
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
	@RequestMapping("/dashboard")
	public String moveDashBoard(Model model) {
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

		model.addAttribute("userVehicleCount", userVehicleService.getUserVehicleCount());
		model.addAttribute("userCount", userService.getUserCount());
		model.addAttribute("userCountList", userService.getMonthUserCount());
		return "/jsp/header/dashboard";
	}

	/**
	 * 회원가입 페이지로 이동
	 * 
	 * @return 회원 가입 페이지
	 */
	@RequestMapping("/registration")
	public String moveRegistration(Model model) {
		return "/jsp/registration";
	}

	/**
	 * 헤더 USERS클릭시 이동
	 * 
	 * @return 유저 관리 페이지
	 */
	@RequestMapping("/usermanagement")
	public String moveUser(Model model) {
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

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
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

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
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

		List<VehicleVO> vehicleList = vehicleService.getVehicleList();
		Map<String, String> vehicleMap = new HashMap<>();

		for (VehicleVO vo : vehicleList) {
			vehicleMap.put(vo.getModelCode(), vo.getModelName());
		}

		model.addAttribute("vehicleMap", vehicleMap);

		return "/jsp/userrequest";
	}

	/**
	 * 헤더 VEHICLE클릭시 이동
	 * 
	 * @return 차량 관리 페이지
	 */
	@RequestMapping("/vehicle")
	public String moveVehicle(Model model) {
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

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
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

		String version = bundleVersionService.getBundleVersion();
		List<BundleVO> list = bundleService.getBundleList();
		model.addAttribute("bundleList", list);
		model.addAttribute("bundleVersion", version);
		return "/jsp/bundle";
	}

	/**
	 * 헤더 RESTFUL API 클릭시 이동
	 * 
	 * @return API 관리 페이지
	 */
	@RequestMapping("/api")
	public String moveApi(Model model) {
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

		List<ApiVO> list = apiService.getApiList();
		model.addAttribute("apiList", list);
		return "/jsp/api";
	}

	/**
	 * 헤더 PUSH클릭시 이동
	 * 
	 * @return 푸시메시지 관리 페이지
	 */
	@RequestMapping(value = "/pushmessage", method = {  RequestMethod.GET})
	public String movePushMessage( Integer categoryNumber,
			 String location,  String modelCode, Model model) {
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);
		
		
		
		// 공백이 들어왔을 때 Pushmessage Mapper에서 사용하기 때문에 공백대신 null을 넣어준다
		if(location=="")
			location=null;
		if(modelCode=="")
			modelCode=null;
		
		// Pushmessage List를 선택한 category, location, model에 따라 불러온다 
		Map<String, Object> map=new HashMap<>();
		map.put("categoryNumber", categoryNumber);
		map.put("location", location);
		map.put("modelCode", modelCode);
		model.addAttribute("pushMessageList", pushMessageService.getPushMessageListBy(map));

		List<VehicleVO> vehicleList = vehicleService.getVehicleList();
		Map<String, String> vehicleMap = new HashMap<>();

		for (VehicleVO vo : vehicleList) {
			vehicleMap.put(vo.getModelCode(), vo.getModelName());
		}

		model.addAttribute("vehicleMap", vehicleMap);
		
		

		/*if ((request.getParameter("categoryNumber") == null || request.getParameter("categoryNumber").equals("")) && (request.getParameter("location") == null || request.getParameter("location").equals(""))
				&& (request.getParameter("modelCode") == null || request.getParameter("location").equals("")))
			model.addAttribute("pushMessageList", pushMessageService.getPushMessageList());
		//////// select box///////
		if (request.getParameter("categoryNumber") == null || request.getParameter("categoryNumber").equals("")) {
			model.addAttribute("categoryNumber", null);
		} else {
			model.addAttribute("categoryNumber", request.getParameter("categoryNumber"));
			model.addAttribute("pushMessageList", pushMessageService.getPushMessageListBy("categoryNumber", request.getParameter("categoryNumber")));
		}
		if (request.getParameter("location") == null || request.getParameter("location").equals("")) {
			model.addAttribute("location", null);
		} else {
			model.addAttribute("location", request.getParameter("location"));
			model.addAttribute("pushMessageList", pushMessageService.getPushMessageListBy("location", request.getParameter("location")));
		}
		if (request.getParameter("modelCode") == null || request.getParameter("modelCode").equals("")) {
			model.addAttribute("modelCode", null);
		} else {
			model.addAttribute("modelCode", request.getParameter("modelCode"));
			model.addAttribute("pushMessageList", pushMessageService.getPushMessageListBy("modelCode", request.getParameter("modelCode")));
		}*/

		model.addAttribute("messageCategoryList", messageCategoryService.getMessageCategoryList());
		model.addAttribute("messageCategoryMap", messageCategoryService.getMessageCategoryMap());
		model.addAttribute("locationList", userVehicleService.getLocation());
		model.addAttribute("modelList", vehicleService.getVehicleList());

		return "/jsp/pushmessage";
	}

	/**
	 * 헤더 Send Message클릭시 이동
	 * 
	 * @return 푸시메시지 전송 페이지
	 */
	@RequestMapping("/sendmessage")
	public String moveSendMessage(Model model) {
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

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
	public String moveLog(@RequestParam("page") int page, Model model, HttpServletRequest request) {
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

		String query = request.getParameter("query");

		if (query != null) {
			query = "%" + query + "%";
		}

		List<LogVO> list = logService.getLogListPaging(page, query);

		model.addAttribute("logList", list);
		model.addAttribute("pageList", logService.getPageList(page, query));
		model.addAttribute("endPageNum", logService.getEndPageNum(query));
		return "/jsp/log";
	}

	/**
	 * User 선택시 userVehicle 이동
	 * 
	 * @return 유저 차량 관리 페이지
	 */
	@RequestMapping(value = "/userVehicle")
	public String moveUserVehicle(@RequestParam("userId") String userId, Model model, HttpServletResponse response) {
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

		////////////// userVehicleList, vehicleList 초기화///////////////////////////
		List<UserVehicleVO> userVehicleList = userVehicleService.getUserVehicleList(userId);
		model.addAttribute("userVehicleList", userVehicleList);
		List<VehicleVO> vehicleList = new ArrayList<>();
		List<VehicleVO> vehicleModelList = vehicleService.getVehicleList();

		for (int i = 0; i < userVehicleList.size(); i++) {
			vehicleList.add(vehicleService.getVehicle(userVehicleList.get(i).getModelCode()));
		}

		model.addAttribute("vehicleList", vehicleList);
		model.addAttribute("vehicleModelList", vehicleModelList);

		return "/jsp/uservehicle";

	}

	/////////////////// 잠시 생각/////////////////////////////////
	/**
	 * 헤더 ANALYTICS > User 클릭시 이동
	 * 
	 * @return 통계 관리 페이지
	 */
	@RequestMapping("/useranalytics")
	public String moveUserAnalytics(Model model, String selectYear) {
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

		return "/jsp/useranalytics";
	}

	/////////////////// 잠시 생각/////////////////////////////////
	/**
	 * 헤더 ANALYTICS > User Vehicle 클릭시 이동
	 * 
	 * @return 통계 관리 페이지
	 */
	@RequestMapping("/uvanalytics")
	public String moveUserVehicleAnalytics(Model model) {
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

		return "/jsp/uvanalytics";
	}

	/////////////////// 잠시 생각/////////////////////////////////
	/**
	 * 헤더 ANALYTICS > Download Analytics 클릭시 이동
	 * 
	 * @return 통계 관리 페이지
	 */
	@RequestMapping("/downanalytics")
	public String moveDownAnalytics(Model model) {
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

		model.addAttribute("bundleUpdateList", logService.getBundleUpdateCount());
		model.addAttribute("userCountList", userService.getMonthUserCount2());
		List<String> list = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		int year = new Integer(cal.get(Calendar.YEAR));
		int month = cal.get(Calendar.MONTH) + 1;
		for (int i = 0; i < 8; i++) {
			if (month == 0) {
				year -= 1;
				month = 12;
			}
			list.add("'" + year + "-" + month + "'");
			month--;
		}
		model.addAttribute("period", list);
		return "/jsp/downanalytics";
	}

	/////////////////// 잠시 생각/////////////////////////////////
	/**
	 * 헤더 ANALYTICS클릭시 이동
	 * 
	 * @return 통계 관리 페이지
	 */
	@RequestMapping("/messageanalytics")
	public String moveMessageAnalytics(Model model) {
		// 모든 MoveController의 주소마다 header의 User Request 알림표시 업데이트를 위해서 필요하다
		List<UserRequestVO> userRequestList = userRequestService.getUserRequestList();
		model.addAttribute("userRequestList", userRequestList);

		return "/jsp/messageanalytics";
	}

}
