package com.obigo.obigoproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obigo.obigoproject.user.service.UserService;
import com.obigo.obigoproject.userrequest.service.UserRequestService;
import com.obigo.obigoproject.uservehicle.service.UserVehicleService;
import com.obigo.obigoproject.vo.UserVehicleVO;
import com.obigo.obigoproject.vo.UsersVO;

import net.sf.json.JSONObject;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	UserVehicleService userVehicleService;
	@Autowired
	UserRequestService userRequestService;

	/**
	 * 회원가입 등록폼을 통해 유저정보를 전달받으면 유저를 등록하고 로그인 페이지로 이동
	 * 
	 * @return 로그인 페이지
	 */
	@RequestMapping("/signup")
	public String signup(UsersVO vo) {
		vo.setRoleName("ADMIN");
		userService.insertUser(vo);
		return "redirect:/login";
	}

	/**
	 * 유저등록폼을 통해 유저정보를 전달받으면 유저를 등록하고 유저관리페이지로 이동
	 * 
	 * @return 유저관리페이지
	 */
	@RequestMapping("/insertUser")
	public String insertUser(@RequestParam UsersVO vo) {

		userService.insertUser(vo);

		return null;
	}

	/**
	 * 유저수정폼을 통해 유저정보를 전달받으면 유저를 수정하고 유저관리페이지로 이동
	 * 
	 * @return 유저관리페이지
	 */
	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam UsersVO vo) {
		return null;
	}

	/**
	 * 유저 삭제 버튼을 클릭후 확인을 클릭하면 해당 유저의 정보를 삭제 결과를 해당 유저 에게 Pushmessage로 발송해야함
	 * 
	 * @return 유저관리페이지
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam String id) {

		return null;
	}

	/**
	 * 유저 요청 수락 버튼을 클릭 후 요청 차량을 해당 유저에 등록 하고 유저 요청을 DB에서 제거 결과를 해당 유저 에게
	 * Pushmessage로 발송해야함
	 * 
	 * @return 유저요청페이지
	 */
	@RequestMapping(value="/acceptrequest", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String acceptRequest(@RequestParam("userRequestNumber") int userRequestNumber) {
		userRequestService.acceptUserRequest(userRequestNumber);
		JSONObject jobj = new JSONObject();
		/// 푸시메시지 알아서 날려////
		return jobj.toString();
	}

	/**
	 * 유저 요청 거절 버튼을 클릭 후 유저 요청을 DB에서 제거
	 * 
	 * @return 유저요청페이지
	 */
	@RequestMapping(value="/rejectrequest", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String rejectRequest(@RequestParam("userRequestNumber") int userRequestNumber) {
		userRequestService.deleteUserRequest(userRequestNumber);
		JSONObject jobj = new JSONObject();
		return jobj.toString();
	}

	/**
	 * 회원가입 폼에서 아이디 중복 확인 버튼 클릭시 수행
	 * 
	 * @return 회원가입 폼
	 */
	@RequestMapping("/idcheck")
	@ResponseBody
	public String idCheck(@RequestParam("userId") String userId) {
		JSONObject jobj = new JSONObject();
		jobj.put("flag", userService.idCheck(userId));
		return jobj.toString();
	}

	/**
	 * 로그인시 아이디와 비밀번호 체크 // 성공시 세션 생성해줘야함.
	 * 
	 * @return 메인페이지
	 */
	@RequestMapping("/logincheck")
	public String login(@RequestParam String userId, @RequestParam String password, HttpSession session) {
		System.out.println("로그인체크 컨트롤러");
		if (userService.passwordCheck(userId, password)) {
			session.setAttribute("userId", userId);
			return "main";
		} else
			session.setAttribute("loginnotok", "ID나 PASSWORD 확인해주세요");
		return "redirect:/login";
	}

	/**
	 * 로그인, 회원가입 페이지를 제외한 모든 페이지에서 로그아웃 수행
	 * 
	 * @return 로그인 페이지
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		return null;
	}

	////////////// 관리자가 유저 차량 관리하는 기능///////////////////////////
	/**
	 * 유저 차량 등록 폼에서 정보 입력후 등록 버튼 클릭시 유저 차량 등록 수행
	 * 
	 * @return 유저 차량 관리 페이지
	 */
	@RequestMapping("/insertuservehicle")
	public String insertUserVehicle(@RequestParam UserVehicleVO vo) {
		return null;
	}

	/**
	 * 유저 차량 수정 폼에서 정보 입력후 등록 버튼 클릭시 유저 차량 수정 수행
	 * 
	 * @return 유저 차량 관리 페이지
	 */
	@RequestMapping("/updateuservehicle")
	public String updateUserVehicle(@RequestParam UserVehicleVO vo) {
		return null;
	}

	/**
	 * 유저 차량 관리 페이지에서 특정 차량 삭제 버튼 클릭시 유저 차량 삭제 수행
	 * 
	 * @return 유저 차량 관리 페이지
	 */
	@RequestMapping("/deleteuservehicle")
	public String deleteUserVehicle(@RequestParam int userVehicleNumber) {
		return null;
	}
	/////////////////////////////////////////////////////////////////////

}
