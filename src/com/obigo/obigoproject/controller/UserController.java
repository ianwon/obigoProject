package com.obigo.obigoproject.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.obigo.obigoproject.log.service.LogService;
import com.obigo.obigoproject.pushmessage.service.PushMessageService;
import com.obigo.obigoproject.user.service.UserService;
import com.obigo.obigoproject.userrequest.service.UserRequestService;
import com.obigo.obigoproject.uservehicle.service.UserVehicleService;
import com.obigo.obigoproject.util.obigoUtils;
import com.obigo.obigoproject.vo.UserVehicleVO;
import com.obigo.obigoproject.vo.UsersVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	UserVehicleService userVehicleService;
	@Autowired
	UserRequestService userRequestService;
	@Autowired
	LogService logService;
	@Autowired
	PushMessageService pushmessageService;
	@Autowired
	JavaMailSender mailSender;

	/**
	 * 회원가입 등록폼을 통해 유저정보를 전달받으면 유저를 등록하고 로그인 페이지로 이동
	 * 
	 * @return 로그인 페이지
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(UsersVO vo) {
		vo.setRoleName("ADMIN");
		vo.setUserId(vo.getUserId().toLowerCase());
		userService.insertUser(vo);
		return "redirect:/login";
	}

	/**
	 * 유저등록폼을 통해 유저정보를 전달받으면 유저를 등록하고 유저관리페이지로 이동
	 * 
	 * @return 유저관리페이지
	 */
	@RequestMapping(value = "/insertuser", method = RequestMethod.POST)
	public String insertUser(UsersVO vo) {
		vo.setUserId(vo.getUserId().toLowerCase());
		vo.setRoleName("USER");
		userService.insertUser(vo);
		return "redirect:/usermanagement";
	}

	/**
	 * 유저수정폼을 통해 유저정보를 전달받으면 유저를 수정하고 유저관리페이지로 이동
	 * 
	 * @return 유저관리페이지
	 */
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public String updateUser(UsersVO vo) {
		userService.updateUser(vo);
		if (userService.getUser(vo.getUserId()).getRoleName().equals("ADMIN"))
			return "redirect:/adminmanagement";
		else
			return "redirect:/usermanagement";

	}

	/**
	 * 유저 삭제 메서드
	 * 
	 * @return null : AJAX의 delete 요청에 대한 응답으로 아무 의미 없는 data를 보내줌
	 */
	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	@ResponseBody
	public String deleteUser(String userId, HttpSession session) {
		if (session.getAttribute("LoginOK").equals(userId))
			return "false";
		else
			userService.deleteUser(userId);
		return null;
	}

	/**
	 * 유저 차량 등록 요청 수락하는 메서드 function=유저 요청 수락 버튼을 클릭 후 요청 차량을 해당 유저에 등록 하고 유저 요청을 DB에서 제거 결과를 해당 유저 에게 Pushmessage로 발송해야함
	 * 
	 * @return JSON : AJAX의 요청에 대한 응답으로 아무 의미 없는 data를 보내줌
	 */
	@RequestMapping(value = "/acceptrequest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String acceptRequest(@RequestParam("userRequestNumber") int userRequestNumber, @RequestParam("userId") String userId, @RequestParam("flag") String flag) {

		try {
			if (userRequestService.acceptUserRequest(userRequestNumber))
				pushmessageService.sendUserReqeustPushMessage(userId, flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jobj = new JSONObject();

		return jobj.toString();
	}

	/**
	 * 유저 요청을 거절하는 메서드 function=유저 요청 거절 버튼을 클릭 후 유저 요청을 DB에서 제거 그리고 유저에게 Push message 보내줌
	 * 
	 * @return JSON : AJAX의 요청에 대한 응답으로 아무 의미 없는 data를 보내줌
	 */
	@RequestMapping(value = "/rejectrequest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String rejectRequest(@RequestParam("userRequestNumber") int userRequestNumber, @RequestParam("userId") String userId, @RequestParam("flag") String flag) {
		try {
			if (userRequestService.deleteUserRequest(userRequestNumber))
				pushmessageService.sendUserReqeustPushMessage(userId, flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jobj = new JSONObject();
		return jobj.toString();
	}

	/**
	 * 회원가입 폼에서 아이디 중복 확인 버튼 클릭시 수행하는 메서드 parameter = "userId":User ID
	 * 
	 * @return JSON : 유저의 동일 ID 존재하는지 여부
	 */
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String idCheck(@RequestParam("userId") String userId) {
		userId = userId.toLowerCase();
		JSONObject jobj = new JSONObject();
		jobj.put("flag", userService.idCheck(userId, "USER"));
		return jobj.toString();
	}

	/**
	 * 유저의 ID/PW 가 일치하는지 체크하는 메서드
	 * 
	 * @return JSON : ID와 PW가 DB에 등록된 유저의 ID/PW 정보와 일치하는지 체크
	 */
	@RequestMapping(value = "/passwordcheck", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String passwordCheck(@RequestParam("userId") String userId, @RequestParam("password") String password) {
		JSONObject jobj = new JSONObject();
		userId = userId.toLowerCase();

		if (userService.passwordCheck(userId, password, "USER")) {
			jobj.put("flag", true);
		} else {
			jobj.put("flag", false);
		}

		return jobj.toString();
	}

	/**
	 * 유저의 ID/PW 가 일치하는지 체크하는 메서드
	 * 
	 * @return JSON : ID와 PW가 DB에 등록된 유저의 ID/PW 정보와 일치하는지 체크
	 */
	@RequestMapping(value = "/adminpasswordcheck", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String adminPasswordCheck(@RequestParam("userId") String userId, @RequestParam("password") String password) {
		JSONObject jobj = new JSONObject();
		userId = userId.toLowerCase();

		if (userService.passwordCheck(userId, password, "ADMIN")) {
			jobj.put("flag", true);
		} else {
			jobj.put("flag", false);
		}

		return jobj.toString();
	}

	/**
	 * 로그인시 아이디와 비밀번호 체크하는 메서드 function=성공시 세션 생성해줘야함.
	 * 
	 * @return 메인페이지/로그인페이지
	 */
	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	public String login(@RequestParam String userId, @RequestParam String password, HttpSession session) {
		userId = userId.toLowerCase();
		if (userService.passwordCheck(userId, password, "ADMIN")) {
			session.setAttribute("LoginOK", userId);
			return "redirect:/dashboard";
		} else {
			return "redirect:/login";
		}
	}

	/**
	 * 로그인, 회원가입 페이지를 제외한 모든 페이지에서 로그아웃 수행하는 메서드
	 * 
	 * @return 로그인 페이지
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	////////////// 관리자가 유저 차량 관리하는 기능///////////////////////////
	/**
	 * 유저 차량 등록 폼에서 정보 입력후 등록 버튼 클릭시 유저 차량 등록 수행
	 * 
	 * @return 유저 차량 관리 페이지
	 */
	@RequestMapping(value = "/insertuservehicle", method = RequestMethod.POST)
	public String insertUserVehicle(UserVehicleVO vo) {
		userVehicleService.insertUserVehicle(vo);
		return "redirect:/userVehicle?userId=" + vo.getUserId();
	}

	////////////// Analytics에서 User Vehicle에 대한 통계 ///////////////////////////
	/**
	 * Analytics에서 User Vehicle에 등록된 Model 종류별로 등록된 차량의 대수의 정보를 전달하는 메서드
	 * 
	 * @return JSON Array : 유저 차량 종류별 사용 대수 정보
	 */
	@RequestMapping(value = "/countingbymodel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String countingByModelName() {
		List<Map<String, Object>> list = userVehicleService.getCountingByModelName();
		JSONArray jArray = new JSONArray();
		JSONObject jObj = new JSONObject();

		// bootstrap 통계 그래프를 사용하기 위해서 json data 명칭으로 label, data를 사용해야 한다.
		for (int i = 0; i < list.size(); i++) {
			jObj.put("name", list.get(i).get("MODEL_NAME"));
			jObj.put("y", list.get(i).get("COUNTING"));
			// jObj.put("code", list.get(i).get("MODEL_CODE"));
			jArray.add(i, jObj);
		}
		return jArray.toString();
	}

	////////////// Analytics에서 User에 대한 통계 ///////////////////////////
	/**
	 * Analytics > User에서 검색한 ID에 해당하는 User List를 전달하는 메서드
	 * 
	 * @return JSON : 검색대상에 해당하는 유저들의 정보 List
	 */
	@RequestMapping(value = "/loginuserlist", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getLoginUserList(@RequestParam String userId) {
		JSONArray jArray = new JSONArray();
		JSONObject jObj = new JSONObject();

		// userId가 null 또는 ""일 경우, 실시간 User ID를 검색해서 보여주는 테이블에
		// 아무 User List도 보여주지 않기 위함
		if (userId != null && !"".equals(userId)) {

			List<UsersVO> list = userService.getLoginUserList("%" + userId + "%");
			if (list != null) {
				for (UsersVO vo : list) {
					jArray.add(vo);
				}
			}
		}
		jObj.put("data", jArray);
		return jObj.toString();

	}

	////////////// Analytics에서 User에 대한 통계 ///////////////////////////
	/**
	 * Analytics > User에서 선택된 User ID의 매달 User Login Count를 배열로 전달하는 메서드
	 * 
	 * @return JSON Array : 유저들의 로그인 통계 데이터
	 */
	@RequestMapping(value = "/countuserlogin", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String countUserLogin(@RequestParam String userId, @RequestParam String selectYear) {
		JSONArray jArray = new JSONArray();
		List<Integer> list = null;
		Calendar cal = Calendar.getInstance();

		if (selectYear == null) {
			selectYear = String.valueOf(cal.get(Calendar.YEAR));
		}

		selectYear = selectYear.substring(2);

		// User Login 통계 그래프 출력할 때, 검색 Input text에 아무것도 입력하지 않았을 경우에 대한 처리
		if (userId == null || "".equals(userId) || "No data available in table".equals(userId)) {
			// 전체 Login 횟수에 대한 통계 값을 가져오는 메서드
			list = logService.getMonthLogCount("%login%", selectYear);
		} else {
			// 특정 User ID에 대한 매달 Login 횟수에 대한 통계 값을 가져오는 메서드
			list = logService.getUserMonthLogCount(selectYear, "%login%", "%" + "\"userid\":\"" + userId + "\"%");
		}

		if (list != null) {
			for (Integer i : list) {
				jArray.add(i);
			}
		}
		return jArray.toString();
	}

	/**
	 * 유저 차량 수정 폼에서 정보 입력후 등록 버튼 클릭시 유저 차량 수정 수행
	 * 
	 * @return 유저 차량 관리 페이지
	 */
	@RequestMapping(value = "/updateuservehicle", method = RequestMethod.POST)
	public String updateUserVehicle(@RequestParam UserVehicleVO vo) {
		return null;
	}

	/**
	 * 유저 차량 관리 페이지에서 특정 차량 삭제 버튼 클릭시 유저 차량 삭제 수행
	 * 
	 * @return 유저 차량 관리 페이지
	 */
	@RequestMapping("/deleteuservehicle")
	public String deleteUserVehicle(String userId, int uvnumber) {
		
		userVehicleService.deleteUserVehicle(uvnumber);
		
		return "redirect:/userVehicle?userId="+userId;
	}

	/**
	 * 유저의 ID/PW 가 일치하는지 체크하는 메서드
	 * 
	 * @return JSON : ID와 PW가 DB에 등록된 유저의 ID/PW 정보와 일치하는지 체크
	 */
	@RequestMapping(value = "/checkvinnumber", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String checkVinNumber(@RequestParam("vin") String vin) {
		JSONObject jobj = new JSONObject();
		jobj.put("flag", userVehicleService.checkVinNumber(vin));

		return jobj.toString();
	}

	/**
	 * 캡쳐된 화면 서버 저장
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/emailanalytics", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String createImage(HttpServletRequest request) throws Exception {
		String binaryData = request.getParameter("imgSrc");
		FileOutputStream stream = null;
		ModelAndView mav = new ModelAndView();
		String fileName = null;
		JSONObject jobj = new JSONObject();

		try {
			if (binaryData == null || binaryData == "") {
				throw new Exception();
			}
			binaryData = binaryData.replaceAll("data:image/png;base64,", "");
			binaryData = binaryData.replaceAll("imgSrc=", "");
			byte[] file = Base64.decodeBase64(binaryData);
			fileName = UUID.randomUUID().toString();
			String saveDir = obigoUtils.path + File.separator + "analytics" + File.separator;
			File saveDirFile = new File(saveDir);
			if (!saveDirFile.exists()) {
				saveDirFile.mkdirs();
			}

			stream = new FileOutputStream(saveDir + fileName + ".png");
			stream.write(file);
			stream.close();
			System.out.println("파일 작성 완료");

			// 관리자에게 통계 그래프 캡쳐한 이미지 파일 첨부하여 이메일 보내기
			sendMail(fileName + ".png");
			jobj.put("flag", true);

		} catch (Exception e) {
			System.out.println("파일이 정상적으로 넘어오지 않았습니다");
			jobj.put("flag", false);
			return jobj.toString();
		} finally {
			stream.close();
		}
		return jobj.toString();

	}

	public void sendMail(String fileName) {
		Calendar calendar1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 보내는 분의 이메일 주소
		// String from = obigoUtils.getSendFrom();
		// 이메일 제목
		String subject = "Analytics 파일 보내드립니다.";

		System.out.println("스케줄 실행 : " + dateFormat.format(calendar1.getTime()));

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setTo(obigoUtils.sendTo);
			messageHelper.setFrom(obigoUtils.sendFrom);
			messageHelper.setSubject(subject); // 메일제목은 생략이 가능하다
			// messageHelper.addInline("table.pdf", new
			// FileDataSource("c:/pdftest/table.pdf"));

			MimeBodyPart bodypart = new MimeBodyPart();
			bodypart.setContent("통계 이미지 파일 첨부되었습니다.", "text/html;charset=euc-kr");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(bodypart);

			String saveDir = obigoUtils.path + "analytics" + File.separator;
			File saveDirFile = new File(saveDir);
			String path = obigoUtils.path + "analytics" + File.separator + fileName;

			if (!saveDirFile.exists()) {
				saveDirFile.mkdirs();
			}
			MimeBodyPart attachPart = new MimeBodyPart();
			// attachPart.setDataHandler(new
			// DataHandler(attachment,"text/xml"));
			attachPart.setDataHandler(new DataHandler(new FileDataSource(new File(path))));
			attachPart.setFileName(fileName); // 파일명
			multipart.addBodyPart(attachPart);
			message.setContent(multipart);
			mailSender.send(message);
			// mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}