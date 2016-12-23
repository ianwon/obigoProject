package com.obigo.obigoproject.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obigo.obigoproject.androiduservehicle.service.AndroidUserVehicleService;
import com.obigo.obigoproject.api.service.ApiService;
import com.obigo.obigoproject.bundle.service.BundleService;
import com.obigo.obigoproject.bundleversion.service.BundleVersionService;
import com.obigo.obigoproject.log.service.LogService;
import com.obigo.obigoproject.messagecategory.service.MessageCategoryService;
import com.obigo.obigoproject.pushmessage.service.PushMessageService;
import com.obigo.obigoproject.registrationid.service.RegistrationidService;
import com.obigo.obigoproject.resource.service.ResourceService;
import com.obigo.obigoproject.user.service.UserService;
import com.obigo.obigoproject.usermessage.service.UserMessageService;
import com.obigo.obigoproject.userrequest.service.UserRequestService;
import com.obigo.obigoproject.uservehicle.service.UserVehicleService;
import com.obigo.obigoproject.vehicle.service.VehicleService;
import com.obigo.obigoproject.vo.BundleVO;
import com.obigo.obigoproject.vo.RegistrationidVO;
import com.obigo.obigoproject.vo.ResourceVO;
import com.obigo.obigoproject.vo.UserRequestVO;
import com.obigo.obigoproject.vo.UsersVO;

import net.sf.json.JSONArray;
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
	@Autowired
	AndroidUserVehicleService androiduservehicleService;
	@Autowired
	RegistrationidService registrationidService;

	/**
	 * 번들번들번들번들번들번들 받아가시오 ~
	 * 
	 * @return 번들~~~~~~~~~~~~~
	 */
	@RequestMapping(value = "/api/bundledown", method = { RequestMethod.GET })
	@ResponseBody
	public void bundleDown(HttpServletResponse response) {
		String path = "c:/obigo/bundle/" + bundleService.getBundleBybundleVersion(bundleVersionService.getBundleVersion()).getFileUpload();
		FileInputStream fs = null;
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
				fs = new FileInputStream("C:/obigo/no_img.gif");
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
	}

	/**
	 * Image 받아가시오 ~
	 * 
	 * @return 이미지~
	 */
	@RequestMapping(value = "/api/image/{select}/{imagename:.+}", method = { RequestMethod.GET })
	@ResponseBody
	public void image(@PathVariable String select, @PathVariable String imagename, HttpServletResponse response) {
		String path = "c:/obigo/" + select + "/";

		path += imagename;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(path);
			byte[] iconImage = new byte[fs.available()];
			fs.read(iconImage);
			response.setContentType("image/jpg");
			response.getOutputStream().write(iconImage);
		} catch (Exception e1) {
			try {
				fs = new FileInputStream("C:/obigo/no_img.gif");
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
	}

	/**
	 * 번들 체크 Api parameter : "bundleVersion":번들버전
	 * 
	 * @return "flag" : 결과
	 */
	@RequestMapping(value = "/api/bundlecheck/{bundleVersion}", method = { RequestMethod.GET })
	@ResponseBody
	public String bundlecheck(@PathVariable String bundleVersion) {
		JSONObject jobj = new JSONObject();
		if (bundleVersionService.getBundleVersion().equals(bundleVersion))
			jobj.put("flag", true);
		else
			jobj.put("flag", false);
		return jobj.toString();
	}

	/**
	 * 번들 업데이트 Api
	 * 
	 * @return "bundle" : 번들 주소값
	 */
	@RequestMapping(value = "/api/bundleupdate", method = { RequestMethod.GET })
	@ResponseBody
	public String bundleUpdate() {
		JSONObject jobj = new JSONObject();
		jobj.put("path", bundleService.getBundleBybundleVersion(bundleVersionService.getBundleVersion()).getFileUpload());
		return jobj.toString();
	}

	/**
	 * 유저 차량 정보 리스트 Api parameter = "userId":유저아이디
	 * 
	 * @return "userVehicleList" : 유저 차량 리스트
	 */
	@RequestMapping(value = "/api/uservehicle/{userId}", method = { RequestMethod.GET })
	@ResponseBody
	public String userVehicle(@PathVariable String userId) {
		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(androiduservehicleService.getAndroidUserVehicleListByUserid(userId));
		return jsonArray.toString();
	}

	/**
	 * 유저 차량 정보 Api parameter = "modelCode":차량코드
	 * 
	 * @return "userVehicle" : 유저 차량 정보
	 */
	@RequestMapping(value = "/api/cardetailinfo/{modelCode}", method = { RequestMethod.GET })
	@ResponseBody
	public String userVehicleDetail(@PathVariable String modelCode) {
		JSONObject jobj = new JSONObject();
		jobj.put("userVehicle", vehicleService.getVehicle(modelCode));
		return jobj.toString();
	}

	/**
	 * 유저 차량 등록 요청 Api parameter = "userId":유저아이디, "modelCode":차량코드, "color":색상, "location":지역, "vin":고유번호
	 * 
	 * @return "flag" : 등록 여부
	 */

	@RequestMapping(value = "/api/userrequest", method = { RequestMethod.POST })
	@ResponseBody
	public String insertUserRequest(@RequestBody String data) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		UserRequestVO vo = mapper.readValue(data, UserRequestVO.class);
		if (userRequestService.insertUserRequest(vo) == true)
			return "true";
		else
			return "false";
	}

	/**
	 * 유저 푸시메시지 리스트 요청 Api parameter = "userId":유저아이디, "index":페이지번호
	 * 
	 * @return "messageList" : 메시지 리스트
	 */
	@RequestMapping(value = "/api/message/{userId}", method = { RequestMethod.GET })
	@ResponseBody
	public String getMessageList(@PathVariable String userId) {
		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(pushMessageService.getPushMessageList(userId));
		return jsonArray.toString();
	}

	/////////////////////////////////////////////////////////////////////
	/*
	 * 로그인시 Registration ID 가져오기(받은 아이디랑 비밀번호로 db에서 정보를 찾고 registrationid에 token 값으로 업데이트)
	 * 
	 */
	@RequestMapping(value = "/api/registrationid", method = RequestMethod.POST)
	public String insertRegistrationid(@RequestBody String data) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		RegistrationidVO vo = mapper.readValue(data, RegistrationidVO.class);
		try {
			registrationidService.insertRegistrationid(vo);
		} catch (Exception e) {
		}
		return "true";
	}

	@RequestMapping(value = "/api/vehicle", method = RequestMethod.GET)
	@ResponseBody
	public String getVehicleList() {
		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(vehicleService.getVehicleList());
		return jsonArray.toString();
	}

	@RequestMapping(value = "/api/user/{userId}", method = RequestMethod.GET)
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

		return jobj.toString();
	}

	@RequestMapping(value = "/api/login", method = RequestMethod.GET)
	@ResponseBody
	public String login(@RequestParam String userid, @RequestParam String password) {
		// if (userService.passwordCheck(userid, password) != true)
		// return "false";
		// else
		return "true";
	}

	@RequestMapping(value = "/api/deleteregistrationid", method = RequestMethod.DELETE)
	public String logout(@RequestParam String registrationId) {
		if (registrationidService.deleteRegistrationid(registrationId) != true)
			return "false";
		else
			return "true";
	}

	@RequestMapping(value = "/api/bundleversioncheck", method = RequestMethod.GET)
	@ResponseBody
	public String bundleVersioncheck(@RequestParam String bundleVersion) {
		System.out.println(bundleVersion);
		System.out.println("어떤게온거니.?");
		System.out.println(bundleVersionService.getBundleVersion());
		if (bundleVersion.equals(bundleVersionService.getBundleVersion()))
			return "true";
		else
			return "false";
	}

	@RequestMapping(value = "/api/bundleversionupdate", method = RequestMethod.GET)
	@ResponseBody
	public String getbundle() {
		BundleVO bundleVO = bundleService.getBundleBybundleVersion(bundleVersionService.getBundleVersion());
		JSONArray jsonarray = new JSONArray();
		jsonarray.addAll(resourceService.getResourceListBybundleKey(bundleVO.getBundleKey()));
		return jsonarray.toString();
	}

}
