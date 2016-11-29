package com.obigo.obigoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.obigo.obigoproject.messagecategory.service.MessageCategoryService;
import com.obigo.obigoproject.pushmessage.service.PushMessageService;
import com.obigo.obigoproject.usermessage.service.UserMessageService;
import com.obigo.obigoproject.vo.PushMessageVO;

@Controller
public class PushMessageController {
	@Autowired
	PushMessageService pushMessageService;
	@Autowired
	UserMessageService userMessageService;
	@Autowired
	MessageCategoryService messageCategoryService;

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

}
