package com.obigo.obigoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obigo.obigoproject.messagecategory.service.MessageCategoryService;
import com.obigo.obigoproject.pushmessage.service.PushMessageService;
import com.obigo.obigoproject.usermessage.service.UserMessageService;
import com.obigo.obigoproject.uservehicle.service.UserVehicleService;
import com.obigo.obigoproject.vo.PushMessageVO;

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
	 * 
	 * @return 푸시 메시지 관리 페이지
	 */
	@RequestMapping("/sendtextmessage")
	public String sendTextMessage(PushMessageVO vo) {
		pushMessageService.insertPushMessage(vo);
		pushMessageService.sendPushMessageToGcm(vo);
		List<PushMessageVO> pushMessage = pushMessageService.getPushMessageList();
		List<String> messageList = userVehicleService.getUserId(vo);
//		for(int i=0;i<messageList.size();i++){
//			UserMessageVO messagevo = new UserMessageVO();
//			messagevo.setMessageNumber(vo.getMessageNumber());
//			messagevo.setUserId(messageList.get(i));
//			System.out.println(messagevo);
//			userMessageService.insertUserMessage(messagevo);
//		}
		return "redirect:/pushmessage";
	}

	/**
	 * Text Area의 값을 Category로 선택한 대상자에게 메시지 전송 + FILE포함
	 * 
	 * @return 푸시 메시지 관리 페이지
	 */
	@RequestMapping("/sendmarketingmessage")
	public String sendMarketingMessage(@RequestParam PushMessageVO vo) {
		return null;
	}

	/**
	 * Text Area의 값을 Category로 선택한 대상자에게 메시지 전송 + FILE포함
	 * 
	 * @return 푸시 메시지 관리 페이지
	 */
	@RequestMapping(value = "/deletepushmessage", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String deleteMessage(@RequestParam("messageNumber") int messageNumber) {
		JSONObject jobj = new JSONObject();
		if (pushMessageService.deletePushMessage(messageNumber))
			jobj.put("flag", true);
		else
			jobj.put("flag", false);

		return jobj.toString();
	}

}
