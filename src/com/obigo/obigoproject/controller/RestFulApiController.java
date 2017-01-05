package com.obigo.obigoproject.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

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
import com.obigo.obigoproject.util.obigoUtils;
import com.obigo.obigoproject.vehicle.service.VehicleService;
import com.obigo.obigoproject.vo.BundleVO;
import com.obigo.obigoproject.vo.LogVO;
import com.obigo.obigoproject.vo.RegistrationidVO;
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

	LogVO vo = new LogVO();

	/**
	 * 번들번들번들번들번들번들 받아가시오 ~
	 * 
	 * @return 번들~~~~~~~~~~~~~
	 */
	@RequestMapping(value = "/api/bundledown", method = { RequestMethod.GET })
	@ResponseBody
	public void bundleDown(HttpServletResponse response) {
		String path = obigoUtils.getPath() + "bundle" + File.separator + bundleService.getBundleBybundleVersion(bundleVersionService.getBundleVersion()).getFileUpload();
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
				fs = new FileInputStream(obigoUtils.getPath() + "no_img.gif");
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
		JSONObject jobj = new JSONObject();
		jobj.put("bundleVersion", bundleVersionService.getBundleVersion());
		jobj.put("bundleFile", bundleService.getBundleBybundleVersion(bundleVersionService.getBundleVersion()).getFileUpload());
		vo.setUrl("/api/bundledown");
		vo.setBody("null");
		vo.setReturned(jobj.toString());
		logService.insertLog(vo);
	}

	// @RequestMapping(value = "/api/bundledownn", method = { RequestMethod.GET })
	// @ResponseBody
	// public void bundleDown22(HttpServletResponse response) {
	// String path = "c:/obigo/vehicle/bfff2677a6680ea95fda98295d464e14c9eb2a6b555c2da35293fe692d58d2b6.png";
	// FileInputStream fs = null;
	// try {
	// fs = new FileInputStream(path);
	// byte[] fileByte = new byte[fs.available()];
	// fs.read(fileByte);
	// response.setContentType("application/octet-stream");
	// response.setContentLength(fileByte.length);
	// response.setHeader("Content-Disposition", "attachment; fileName=\"" +
	// URLEncoder.encode("bfff2677a6680ea95fda98295d464e14c9eb2a6b555c2da35293fe692d58d2b6.png", "UTF-8") +
	// "\";");
	// response.setHeader("Content-Transfer-Encoding", "binary");
	// response.getOutputStream().write(fileByte);
	// } catch (Exception e1) {
	// try {
	// fs = new FileInputStream("C:/obigo/no_img.gif");
	// byte[] fileByte = new byte[fs.available()];
	// fs.read(fileByte);
	// response.setContentType("application/octet-stream");
	// response.setContentLength(fileByte.length);
	// response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode("no_img.gif", "UTF-8") + "\";");
	// response.setHeader("Content-Transfer-Encoding", "binary");
	// response.getOutputStream().write(fileByte);
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// try {
	// response.getOutputStream().close();
	// } catch (Exception e) {
	// // e.printStackTrace();
	// }
	// }
	//
	// } finally {
	// try {
	// response.getOutputStream().close();
	// } catch (Exception e) {
	// // e.printStackTrace();
	// }
	// }
	//
	// }

	/**
	 * Image 받아가시오 ~
	 * 
	 * @return 이미지~
	 */
	@RequestMapping(value = "/api/image/{select}/{imagename:.+}", method = { RequestMethod.GET })
	@ResponseBody
	public void image(@PathVariable String select, @PathVariable String imagename, HttpServletResponse response) {
		String path = obigoUtils.getPath() + select + File.separator;

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
				fs = new FileInputStream(obigoUtils.getPath() + "no_img.gif");
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
		JSONObject jobj = new JSONObject();
		jobj.put("select", select);
		jobj.put("imagename", imagename);
		vo.setUrl("/api/image");
		vo.setBody(jobj.toString());
		vo.setReturned("null");
		logService.insertLog(vo);
	}

	/**
	 * 번들 체크 Api parameter : "bundleVersion":번들버전
	 * 
	 * @return "flag" : 결과
	 */
	@RequestMapping(value = "/api/bundlecheck/{bundleVersion}", method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String bundlecheck(@PathVariable String bundleVersion) {
		JSONObject jobj = new JSONObject();
		if (bundleVersionService.getBundleVersion().equals(bundleVersion))
			jobj.put("flag", true);
		else
			jobj.put("flag", false);
		JSONObject bodyJobj = new JSONObject();
		bodyJobj.put("bundleVersion", bundleVersion);

		vo.setUrl("/api/bundlecheck");
		vo.setBody(bodyJobj.toString());
		vo.setReturned(jobj.toString());
		logService.insertLog(vo);
		return jobj.toString();
	}

	/**
	 * 번들 업데이트 Api
	 * 
	 * @return "bundle" : 번들 주소값
	 */
	@RequestMapping(value = "/api/bundleupdate", method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String bundleUpdate() {
		JSONObject jobj = new JSONObject();
		jobj.put("path", bundleService.getBundleBybundleVersion(bundleVersionService.getBundleVersion()).getFileUpload());

		vo.setUrl("/api/bundleupdate");
		vo.setBody("null");
		vo.setReturned(jobj.toString());
		logService.insertLog(vo);
		return jobj.toString();
	}

	/**
	 * 유저 차량 정보 리스트 Api parameter = "userId":유저아이디
	 * 
	 * @return "userVehicleList" : 유저 차량 리스트
	 */
	@RequestMapping(value = "/api/uservehicle/{userId}", method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userVehicle(@PathVariable String userId) {
		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(androiduservehicleService.getAndroidUserVehicleListByUserid(userId));
		JSONObject jobj = new JSONObject();
		jobj.put("userId", userId);
		vo.setUrl("/api/uservehicle");
		vo.setBody(jobj.toString());
		vo.setReturned(jsonArray.toString());
		logService.insertLog(vo);
		return jsonArray.toString();
	}

	/**
	 * 유저 차량 정보 Api parameter = "modelCode":차량코드
	 * 
	 * @return "userVehicle" : 유저 차량 정보
	 */
	@RequestMapping(value = "/api/cardetailinfo/{modelCode}", method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userVehicleDetail(@PathVariable String modelCode) {
		JSONObject jobj = new JSONObject();
		jobj.put("userVehicle", vehicleService.getVehicle(modelCode));
		JSONObject bodyJobj = new JSONObject();
		jobj.put("modelCode", modelCode);

		vo.setUrl("/api/cardetailinfo");
		vo.setBody(bodyJobj.toString());
		vo.setReturned(jobj.toString());
		logService.insertLog(vo);
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
		this.vo.setUrl("/api/userrequest");
		this.vo.setBody("null");
		if (userRequestService.insertUserRequest(vo) == true) {
			this.vo.setReturned("true");
			logService.insertLog(this.vo);
			return "true";
		} else {
			this.vo.setReturned("false");
			logService.insertLog(this.vo);
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
		JSONObject jobj = new JSONObject();
		jobj.put("userId", userId);

		vo.setUrl("/api/message");
		vo.setBody(jobj.toString());
		vo.setReturned(jsonArray.toString());
		logService.insertLog(vo);
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

		this.vo.setUrl("/api/registrationid");
		this.vo.setBody("null");
		this.vo.setReturned("true");
		logService.insertLog(this.vo);
		return "true";
	}

	@RequestMapping(value = "/api/vehicle", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getVehicleList() {
		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(vehicleService.getVehicleList());
		vo.setUrl("/api/vehicle");
		vo.setBody("null");
		vo.setReturned(jsonArray.toString());
		logService.insertLog(vo);
		return jsonArray.toString();
	}

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
		bodyJobj.put("userId", userId);

		vo.setUrl("/api/user");
		vo.setBody(bodyJobj.toString());
		vo.setReturned(jobj.toString());
		logService.insertLog(vo);
		return jobj.toString();
	}

	@RequestMapping(value = "/api/login", method = RequestMethod.GET)
	@ResponseBody
	public String login(@RequestParam String userid, @RequestParam String password) {

		vo.setUrl("/api/login");
		JSONObject jobj = new JSONObject();
		System.out.println(userid + password);
		jobj.put("userid", userid);
		jobj.put("password", password);
		vo.setBody(jobj.toString());
		if (userService.passwordCheck(userid, password, "USER") != true) {
			vo.setReturned("false");
			logService.insertLog(vo);
			return "false";
		} else {
			vo.setReturned("true");
			logService.insertLog(vo);
			return "true";
		}
	}

	@RequestMapping(value = "/api/logout", method = RequestMethod.DELETE)
	public String logout(@RequestParam String registrationId) {
		vo.setUrl("/api/logout");
		JSONObject jobj = new JSONObject();
		jobj.put("registrationId", registrationId);
		vo.setBody(jobj.toString());

		if (registrationidService.deleteRegistrationid(registrationId) != true) {
			vo.setReturned("false");
			logService.insertLog(vo);
			return "false";
		} else {
			vo.setReturned("true");
			logService.insertLog(vo);
			return "true";
		}
	}

	@RequestMapping(value = "/api/bundleversioncheck", method = RequestMethod.GET)
	@ResponseBody
	public String bundleVersioncheck(@RequestParam String bundleVersion) {
		System.out.println(bundleVersion);
		System.out.println(bundleVersionService.getBundleVersion());

		vo.setUrl("/api/bundleversioncheck");
		JSONObject jobj = new JSONObject();
		jobj.put("bundleVersion", bundleVersion);
		vo.setBody(jobj.toString());

		if (bundleVersion.equals(bundleVersionService.getBundleVersion())) {
			vo.setReturned("true");
			logService.insertLog(vo);
			return "true";
		} else {
			vo.setReturned("false");
			logService.insertLog(vo);
			return "false";
		}
	}

	@RequestMapping(value = "/api/bundleversionupdate", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getbundle() {
		BundleVO bundleVO = bundleService.getBundleBybundleVersion(bundleVersionService.getBundleVersion());
		JSONArray jsonarray = new JSONArray();
		jsonarray.addAll(resourceService.getResourceListBybundleKey(bundleVO.getBundleKey()));

		vo.setUrl("/api/bundleversionupdate");
		vo.setBody("null");
		vo.setReturned(jsonarray.toString());
		logService.insertLog(vo);
		return jsonarray.toString();
	}

}