package com.obigo.obigoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obigo.obigoproject.api.service.ApiService;
import com.obigo.obigoproject.vo.ApiVO;

import net.sf.json.JSONObject;

@Controller
public class ApiController {

	@Autowired
	ApiService apiService;

	/**
	 * api 등록 폼에서 등록버튼 클릭시 api를 등록해주는 기능
	 * 
	 * @return api 관리 페이지
	 */
	@RequestMapping(value = "/insertapi", method = RequestMethod.POST)
	public String insertApi(ApiVO vo) {
		apiService.insertApi(vo);

		return "redirect:/api";
	}

	/**
	 * api 수정 폼에서 수정버튼 클릭시 api를 수정해주는 기능
	 * 
	 * @return api 관리 페이지
	 */
	@RequestMapping("/updateapi")
	public String updateApi(ApiVO vo) {
		apiService.updateApi(vo);

		return "redirect:/api";
	}

	/**
	 * api 조회 페이지에서 삭제버튼 클릭시 해당 api를 삭제해주는 기능
	 * 
	 * @return api 관리 페이지
	 */
	@RequestMapping(value = "/deleteapi", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String deleteApi(@RequestParam("apiName") String apiName) {
		apiService.deleteApi(apiName);
		JSONObject jobj = new JSONObject();

		return jobj.toString();
	}

	/**
	 * api name이 존재하는지 확인하는 기능
	 * 
	 * @return JSONObject
	 */
	@RequestMapping(value = "/apinamecheck", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String apiNameCheck(@RequestParam("apiName") String apiName) {
		JSONObject jobj = new JSONObject();

		apiName = apiName.trim();

		// getApi 메소드를 통해 apiName이 있으면 not null 임으로 false return
		// null일 경우는 존재하지 않기때문에 true return
		if (apiService.getApi(apiName) != null) {
			jobj.put("flag", false);
		} else {
			jobj.put("flag", true);
		}
		return jobj.toString();
	}

}
