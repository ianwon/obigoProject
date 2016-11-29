package com.obigo.obigoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.obigo.obigoproject.api.service.ApiService;
import com.obigo.obigoproject.vo.ApiVO;

@Controller
public class ApiController {

	@Autowired
	ApiService apiService;

	/**
	 * api 등록 폼에서 등록버튼 클릭시 api를 등록해주는 기능
	 * 
	 * @return api 관리 페이지
	 */
	@RequestMapping("/insertapi")
	public String insertApi(@RequestParam ApiVO vo) {
		return null;
	}

	/**
	 * api 수정 폼에서 수정버튼 클릭시 api를 수정해주는 기능
	 * 
	 * @return api 관리 페이지
	 */
	@RequestMapping("/updateapi")
	public String updateApi(@RequestParam ApiVO vo) {
		return null;
	}

	/**
	 * api 조회 페이지에서 삭제버튼 클릭시 해당 api를 삭제해주는 기능
	 * 
	 * @return api 관리 페이지
	 */
	@RequestMapping(value = "/deleteapi", method = RequestMethod.GET)
	public String deleteApi(String apiName) {
		return null;
	}

}
