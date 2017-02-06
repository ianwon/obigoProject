package com.obigo.obigoproject.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obigo.obigoproject.androiduservehicle.service.AndroidUserVehicleService;
import com.obigo.obigoproject.bundle.service.BundleService;
import com.obigo.obigoproject.bundleversion.service.BundleVersionService;
import com.obigo.obigoproject.log.service.LogService;
import com.obigo.obigoproject.messagecategory.service.MessageCategoryService;
import com.obigo.obigoproject.pushmessage.service.PushMessageService;
import com.obigo.obigoproject.registrationid.service.RegistrationidService;
import com.obigo.obigoproject.user.service.UserService;
import com.obigo.obigoproject.usermessage.service.UserMessageService;
import com.obigo.obigoproject.userrequest.service.UserRequestService;
import com.obigo.obigoproject.uservehicle.service.UserVehicleService;
import com.obigo.obigoproject.util.obigoUtils;
import com.obigo.obigoproject.vehicle.service.VehicleService;
import com.obigo.obigoproject.vo.LogVO;
import com.obigo.obigoproject.vo.RegistrationidVO;
import com.obigo.obigoproject.vo.UserRequestVO;
import com.obigo.obigoproject.vo.UsersVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class RestFulApiController {
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
	@Autowired
	AndroidUserVehicleService androiduservehicleService;
	@Autowired
	RegistrationidService registrationidService;
	@Autowired
	JavaMailSender mailSender;

	// Log를 기록하기 위해서 로그 정보를 저장하는 VO 객체
	LogVO vo = new LogVO();

	/**
	 * App에서 Bundle을 Download하는 Api
	 * 
	 * @return Bundle File을 response를 통해서 전송
	 */
	@RequestMapping(value = "/api/bundle/down", method = { RequestMethod.GET })
	@ResponseBody
	public void bundleDown(HttpServletResponse response) {
		String path = obigoUtils.path + "bundle" + File.separator + bundleService.getBundleBybundleVersion(bundleVersionService.getBundleVersion()).getFileUpload();
		FileInputStream fs = null;

		// Bundle을 response를 통해서 전송하는 과정
		try {
			fs = new FileInputStream(path);
			byte[] fileByte = new byte[fs.available()];
			fs.read(fileByte);
			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length);
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(bundleService.getBundleBybundleVersion(bundleVersionService.getBundleVersion()).getFileUpload(), "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.getOutputStream().write(fileByte);
		} catch (Exception e1) {
			try {
				fs = new FileInputStream(obigoUtils.path + "no_img.gif");
				byte[] fileByte = new byte[fs.available()];
				fs.read(fileByte);
				response.setContentType("application/octet-stream");
				response.setContentLength(fileByte.length);
				response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode("no_img.gif", "UTF-8") + "\";");
				response.setHeader("Content-Transfer-Encoding", "binary");
				response.getOutputStream().write(fileByte);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					response.getOutputStream().close();
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}

		} finally {
			try {
				response.getOutputStream().close();
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}

		// Log 정보를 등록하는 과정
		JSONObject jobj = new JSONObject();
		jobj.put("bundleVersion", bundleVersionService.getBundleVersion());
		jobj.put("bundleFile", bundleService.getBundleBybundleVersion(bundleVersionService.getBundleVersion()).getFileUpload());
		// Log생성
		createLog("/api/bundledown", "null", jobj.toString());
	}

	/**
	 * App에서 Image file을 받아가는 Api
	 * 
	 * @return Image File을 response를 통해서 전송
	 */
	@RequestMapping(value = "/api/image/{select}/{imagename:.+}", method = { RequestMethod.GET })
	@ResponseBody
	public void image(@PathVariable String select, @PathVariable String imagename, HttpServletResponse response) {
		String path = obigoUtils.path + select + File.separator;

		path += imagename;
		FileInputStream fs = null;

		// Image File을 response를 통해서 전송하는 과정
		try {
			fs = new FileInputStream(path);
			byte[] iconImage = new byte[fs.available()];
			fs.read(iconImage);
			response.setContentType("image/jpg");
			response.getOutputStream().write(iconImage);
		} catch (Exception e1) {
			try {

				// 해당 Image가 존재하지 않을 경우, 대체 Image를 전송
				fs = new FileInputStream(obigoUtils.path + "no_img.gif");
				byte[] iconImage = new byte[fs.available()];
				fs.read(iconImage);
				response.setContentType("image/jpg");
				response.getOutputStream().write(iconImage);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					response.getOutputStream().close();
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}

		} finally {
			try {
				response.getOutputStream().close();
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}

		// Log 정보를 등록하는 과정
		JSONObject jobj = new JSONObject();
		jobj.put("select", select);
		jobj.put("imagename", imagename);
		// Log생성
		createLog("/api/image", jobj.toString(), "/api/image/" + select + "/" + imagename);
	}

	/**
	 * 유저 차량 정보 리스트 Api parameter = "userId" : 유저아이디
	 * 
	 * @return "userVehicleList":유저 차량 리스트
	 */
	@RequestMapping(value = "/api/uservehicle/{userId}", method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userVehicle(@PathVariable String userId) {
		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(androiduservehicleService.getAndroidUserVehicleListByUserid(userId));

		// Log 정보를 등록하는 과정
		JSONObject jobj = new JSONObject();
		jobj.put("userid", userId);
		// Log생성
		createLog("/api/uservehicle", jobj.toString(), jsonArray.toString());
		return jsonArray.toString();
	}

	// /**
	// * 유저 차량 정보 Api parameter = "modelCode":차량코드
	// *
	// * @return "userVehicle" : 유저 차량 정보
	// */
	// @RequestMapping(value = "/api/cardetailinfo/{modelCode}", method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	// @ResponseBody
	// public String userVehicleDetail(@PathVariable String modelCode) {
	// JSONObject jobj = new JSONObject();
	// jobj.put("userVehicle", vehicleService.getVehicle(modelCode));
	// JSONObject bodyJobj = new JSONObject();
	// jobj.put("modelCode", modelCode);
	//
	// // Log 정보를 등록하는 과정
	// vo.setUrl("/api/cardetailinfo");
	// vo.setBody(bodyJobj.toString());
	// vo.setReturned(jobj.toString());
	// logService.insertLog(vo);
	// return jobj.toString();
	// }

	/**
	 * 유저 차량 등록 요청 Api parameter = "data":UserRequestVO Class 정보를 담고 있는 JSON data 로서 아래의 정보를 담고있다 "userId":유저아이디, "modelCode":차량코드, "color":색상, "location":지역, "vin":고유번호
	 * 
	 * @return "flag" : 등록 여부
	 */
	@RequestMapping(value = "/api/userrequest", method = { RequestMethod.POST })
	@ResponseBody
	public String insertUserRequest(@RequestBody String data) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		UserRequestVO vo = mapper.readValue(data, UserRequestVO.class);

		if (userRequestService.insertUserRequest(vo) == true) {
			// Log 정보를 등록하는 과정
			createLog("/api/userrequest", data, "true");

			return "true";
		} else {
			// Log 정보를 등록하는 과정
			createLog("/api/userrequest", data, "false");

			return "false";
		}
	}

	/**
	 * 유저 푸시메시지 리스트 요청 Api parameter = "userId":유저아이디, "index":페이지번호
	 * 
	 * @return "messageList" : 메시지 리스트
	 */
	@RequestMapping(value = "/api/message/{userId}", method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getMessageList(@PathVariable String userId) {
		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(pushMessageService.getPushMessageList(userId));

		// Log 정보를 등록하는 과정
		JSONObject jobj = new JSONObject();
		jobj.put("userid", userId);
		createLog("/api/message", jobj.toString(), jsonArray.toString());

		return jsonArray.toString();
	}

	/**
	 * 로그인시 Registration ID 등록 Api function = 받은 아이디랑 비밀번호로 db에서 정보를 찾고 registrationid에 token 값으로 업데이트 parameter = "data":RegistrationidVO
	 * 
	 * @return true/false : Registraionid 등록 성공 여부
	 */
	@RequestMapping(value = "/api/registrationid", method = RequestMethod.POST)
	public String insertRegistrationid(@RequestBody String data) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		RegistrationidVO vo = mapper.readValue(data, RegistrationidVO.class);
		boolean flag = registrationidService.insertRegistrationid(vo);
		String check = String.valueOf(flag);
		// Log 정보를 등록하는 과정
		createLog("/api/registrationid", data, check);

		return check;
	}

	/**
	 * 등록된 차량 List 정보를 보내주는 Api
	 * 
	 * @return JSON Array : 차량정보들을 JSON Data로 보내줌
	 */
	@RequestMapping(value = "/api/vehicle/{userId}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getVehicleList(@PathVariable String userId) {
		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(vehicleService.getVehicleList());

		JSONObject jobj = new JSONObject();
		jobj.put("userid", userId);

		// Log 정보를 등록하는 과정
		createLog("/api/vehicle", jobj.toString(), jsonArray.toString());

		return jsonArray.toString();
	}

	/**
	 * 해당 User ID의 정보를 보내주는 Api parameter = "userId":user의 ID
	 * 
	 * @return UsersVO : User의 정보를 담고 있는 VO
	 */
	@RequestMapping(value = "/api/user/{userId}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getUser(@PathVariable String userId) {
		JSONObject jobj = new JSONObject();
		UsersVO usersVO = userService.getUser(userId);
		jobj.put("userId", usersVO.getUserId());
		jobj.put("name", usersVO.getName());
		jobj.put("password", usersVO.getPassword());
		jobj.put("eMail", usersVO.geteMail());
		jobj.put("phone", usersVO.getPhone());
		jobj.put("roleName", usersVO.getRoleName());
		jobj.put("date", usersVO.getDate());

		JSONObject bodyJobj = new JSONObject();
		bodyJobj.put("userid", userId);

		// Log 정보를 등록하는 과정
		createLog("/api/user", bodyJobj.toString(), jobj.toString());

		return jobj.toString();
	}

	/**
	 * Login Api parameter = "userId":user의 ID, "password":user의 Password
	 * 
	 * @return true/false : 입력한 ID/Password 정보가 일치하는지 여부
	 */
	@RequestMapping(value = "/api/user/login/{userId}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public String login(@PathVariable String userId, @PathVariable String password) {

		JSONObject jobj = new JSONObject();
		jobj.put("userid", userId);
		jobj.put("password", password);
		if (userService.passwordCheck(userId, password, "USER") != true) {
			// Log 정보를 등록하는 과정
			createLog("/api/login", jobj.toString(), "false");

			return "false";
		} else {
			// Log 정보를 등록하는 과정
			createLog("/api/login", jobj.toString(), "true");

			return "true";
		}
	}

	/**
	 * ID/PW 찾기 Api parameter = "name":user의 name, "email":user의 email 주소
	 * 
	 * @return true/false : 입력한 name/email 정보 일치 여부 및 email이 성공적으로 전송될 경우
	 */
	@RequestMapping(value = "/api/user/find/{name}/{email:.+}", method = RequestMethod.GET)
	@ResponseBody
	public String findIDPW(@PathVariable String name, @PathVariable String email) {
		UsersVO userVO = null;

		JSONObject jobj = new JSONObject();
		jobj.put("name", name);
		jobj.put("email", email);

		List<UsersVO> list = userService.findIDPW(name, email);

		if (!(list.isEmpty()) && sendMail(list)) {
			createLog("/api/find", jobj.toString(), "true");
			return "true";
		} else {
			createLog("/api/find", jobj.toString(), "false");
			return "false";
		}
	}

	/**
	 * PW 변경 Api parameter = "userId":user의 ID, "password":user의 Password
	 * 
	 * @return true/false : 비밀번호 변경 성공 실패 여부
	 */
	@RequestMapping(value = "/api/user/password", method = RequestMethod.PUT)
	@ResponseBody
	public String updatePassword(@RequestParam String userid, @RequestParam String password, @RequestParam String newpassword) {
		JSONObject jobj = new JSONObject();
		jobj.put("userid", userid);
		jobj.put("password", password);
		jobj.put("newpassword", newpassword);

		if (userService.updatePassword(userid, password, newpassword) == true) {
			createLog("/api/passwordmodify", jobj.toString(), "true");

			return "true";
		} else {
			createLog("/api/passwordmodify", jobj.toString(), "false");

			return "false";
		}
	}

	/**
	 * Email 전송 Api parameter = "UsersVO": User의 VO
	 * 
	 * @return true/false : email이 성공적으로 전송될 경우
	 */
	public boolean sendMail(List<UsersVO> list) {

		try {

			Calendar calendar1 = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String subject = list.get(0).getName() + "님의 ID/PW를 알려드립니다!";

			System.out.println("스케줄 실행 : " + dateFormat.format(calendar1.getTime()));

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setTo(list.get(0).geteMail());
			messageHelper.setFrom(obigoUtils.sendFrom);
			messageHelper.setSubject(subject); // 메일제목은 생략이 가능하다

			MimeBodyPart bodypart = new MimeBodyPart();
			StringBuilder mailBody = new StringBuilder();
			mailBody.append("===== " + list.get(0).getName() + "님 =====<br>");
			for (int i = 0; i < list.size(); i++) {
				mailBody.append("[User ID : " + list.get(i).getUserId() + "]<br>");
				mailBody.append("[User PW: " + list.get(i).getPassword() + "]<br><br>");
			}
			bodypart.setContent(mailBody.toString(), "text/html;charset=euc-kr");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(bodypart);

			message.setContent(multipart);
			mailSender.send(message);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Logout Api parameter = "registrationId":Login할 때 부여받았던 Registration ID
	 * 
	 * @return true/false : Registration ID의 삭제 성공 여부
	 */
	@RequestMapping(value = "/api/registrationid", method = RequestMethod.DELETE)
	public String logout(@RequestParam String registrationId) {
		JSONObject jobj = new JSONObject();
		jobj.put("registrationId", registrationId);

		// Login할 때 등록된 Registration ID를 삭제 후 결과 return
		if (registrationidService.deleteRegistrationid(registrationId) != true) {
			// Log 정보를 등록하는 과정
			createLog("/api/logout", jobj.toString(), "false");

			return "false";
		} else {
			// Log 정보를 등록하는 과정
			createLog("/api/logout", jobj.toString(), "true");
			return "true";
		}
	}

	/**
	 * Bundle Version Check Api function = App에 설치된 Bundle과 Server에서 적용하고자 하는 Bundle의 Version이 동일한지 체크하는 Api parameter = "bundleVersion":App에 설치된 Bundle Version
	 * 
	 * @return true/false : App과 Server에서 요구하는 Bundle Version이 동일한지 유무에 따라 true/false return
	 */
	@RequestMapping(value = "/api/bundle/check/{bundleVersion:.+}", method = RequestMethod.GET)
	@ResponseBody
	public String bundleVersioncheck(@PathVariable String bundleVersion) {
		JSONObject jobj = new JSONObject();
		jobj.put("bundleVersion", bundleVersion);

		if (bundleVersion.equals(bundleVersionService.getBundleVersion())) {
			// Log 정보를 등록하는 과정
			createLog("/api/bundleversioncheck", jobj.toString(), "true");

			return "true";
		} else {
			// Log 정보를 등록하는 과정
			createLog("/api/bundleversioncheck", jobj.toString(), "false");

			return "false";
		}
	}

	/**
	 * Error Log Api parameter = "url":Error가 발생한 URL
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/errorlog/{url}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void errorLog(@PathVariable String url, @RequestBody String body) {
		JSONObject jobj = JSONObject.fromObject(body);
		JSONObject jobj2 = new JSONObject();
		jobj2.put("url", "/api/" + url);
		jobj2.put("id", jobj.get("body"));

		LogVO vo = new LogVO();
		createLog("/api/errorlog", jobj2.toString(), jobj.getString("returned"));
	}

	public void createLog(String url, String body, String returned) {
		vo.setUrl(url);
		vo.setBody(body);
		vo.setReturned(returned);
		logService.insertLog(vo);
	}

}