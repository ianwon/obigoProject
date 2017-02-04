package com.obigo.obigoproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obigo.obigoproject.message.messagecategory.service.MessageCategoryService;
import com.obigo.obigoproject.message.pushmessage.service.PushMessageService;
import com.obigo.obigoproject.message.pushmessage.vo.PushMessageVO;
import com.obigo.obigoproject.user.usermessage.service.UserMessageService;
import com.obigo.obigoproject.user.usermessage.vo.UserMessageVO;
import com.obigo.obigoproject.user.uservehicle.service.UserVehicleService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class PushMessageController {
	@Autowired
	PushMessageService pushMessageService;
	@Autowired
	UserMessageService userMessageService;
	@Autowired
	MessageCategoryService messageCategoryService;
	@Autowired
	UserVehicleService userVehicleService;

	/**
	 * Text Area의 값을 Category로 선택한 대상자에게 메시지 전송
	 * 
	 * @return 푸시 메시지 관리 페이지
	 * @throws IOException
	 */
	@RequestMapping(value = "/sendtextmessage", method = RequestMethod.POST)
	public String sendTextMessage(PushMessageVO vo, HttpServletRequest request) throws IOException {
		pushMessageService.sendPushMessageToGcm(vo, request);
		PushMessageVO pushMessage = pushMessageService.getPushMessage();
		List<String> userIdList = userVehicleService.getUserId(pushMessage);
		for (String userId : userIdList) {
			UserMessageVO umvo = new UserMessageVO();
			umvo.setMessageNumber(pushMessage.getMessageNumber());
			umvo.setUserId(userId);
			userMessageService.insertUserMessage(umvo);
		}
		return "redirect:/pushmessage";
	}

	/**
	 * 선택한 대상자에게 보낸 Push message List 중 하나를 삭제하는 메서드
	 * 
	 * @return JSON : 삭제 성공 여부를 JSON data를 true/false로 보낸다
	 */
	@RequestMapping(value = "/deletepushmessage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String deleteMessage(@RequestParam("messageNumber") int messageNumber) {
		JSONObject jobj = new JSONObject();
		if (pushMessageService.deletePushMessage(messageNumber))
			jobj.put("flag", true);
		else
			jobj.put("flag", false);

		return jobj.toString();
	}

	/**
	 * Category에 따른 Push message 보낸 횟수를 return 하는 메서드
	 * 
	 * @return JSON Array:Category에 따른 Push message 보낸 횟수
	 */
	@RequestMapping(value = "/getmessageanalytics", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getMessageAnalytics() {
		JSONArray jArray = pushMessageService.getCategoryName();
		return jArray.toString();
	}

}
