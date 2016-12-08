package com.obigo.obigoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.obigo.obigoproject.messagecategory.service.MessageCategoryService;
import com.obigo.obigoproject.pushmessage.service.PushMessageService;
import com.obigo.obigoproject.usermessage.service.UserMessageService;
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

	@RequestMapping("/sendmessage")
	public String sendmessage(PushMessageVO vo){
		 String MESSAGE_ID = String.valueOf(Math.random() % 100 + 1);    //메시지 고유 ID
		    boolean SHOW_ON_IDLE = false;    //옙 활성화 상태일때 보여줄것인지
		    int LIVE_TIME = 1;    //옙 비활성화 상태일때 FCM가 메시지를 유효화하는 시간
		    int RETRY = 2;    //메시지 전송실패시 재시도 횟수
		String simpleApiKey = "AIzaSyAugaUfy_TbAFpMsr91f4_M8cTvePi0now";
		String gcmURL = "https://android.googleapis.com/fcm/send";    
		Sender sender = new Sender(simpleApiKey);
        Message message = new Message.Builder().collapseKey(MESSAGE_ID).delayWhileIdle(SHOW_ON_IDLE).timeToLive(LIVE_TIME).addData("message",vo.getContent()).addData("title", vo.getTitle()).build();
        MulticastResult result1 = sender.send(message,token,RETRY);
        if (result1 != null) {
            List<Result> resultList = result1.getResults();
            for (Result result : resultList) {
                System.out.println(result.getErrorCodeName()); 
            }
        }
    }catch(

	Exception e)
	{
		e.printStackTrace();
	}

	/**
	 * Text Area의 값을 Category로 선택한 대상자에게 메시지 전송
	 * 
	 * 
	 * @return 푸시 메시지 관리 페이지
	 */
	@RequestMapping("/sendtextmessage")
	public String sendTextMessage(@RequestParam PushMessageVO vo) {
		return null;
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
	public String sendMarketingMessage(@RequestParam("messageNumber") int messageNumber) {
		JSONObject jobj = new JSONObject();
		if (pushMessageService.deletePushMessage(messageNumber))
			jobj.put("flag", true);
		else
			jobj.put("flag", false);

		return jobj.toString();
	}

}
