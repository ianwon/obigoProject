package com.obigo.obigoproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obigo.obigoproject.vehicle.service.VehicleService;
import com.obigo.obigoproject.vo.VehicleVO;

import net.sf.json.JSONObject;

@Controller
public class VehicleController {
	@Autowired
	VehicleService vehicleService;

	/**
	 * 자동차 등록폼에서 자동차 등록 버튼 클릭시 차량 등록
	 * 
	 * @return 자동차 관리 페이지
	 */
	@RequestMapping(value = "/insertvehicle", method = RequestMethod.POST)
	public String insertVehicle(VehicleVO vo, HttpServletRequest request) {

		vehicleService.insertVehicle(vo, request);

		return "redirect:/vehicle";
	}

	/**
	 * 자동차 등록폼에서 자동차 등록 버튼 클릭시 동일한 Model Code가 존재하는지 AJAX로 확인
	 * 
	 * @return 자동차 등록 페이지
	 */
	@RequestMapping(value = "/checkmodelcode", method = RequestMethod.POST)
	@ResponseBody
	public String checkModelCode(String modelCode) {
		JSONObject jobj = new JSONObject();
		VehicleVO vo = null;
			vo = vehicleService.getVehicle(modelCode);

			if (vo == null)
				jobj.put("flag", true);
			else
				jobj.put("flag", false);

			return jobj.toString();
	}

	/**
	 * 자동차 수정폼에서 자동차 수정 버튼 클릭시 차량 수정
	 * 
	 * @return 자동차 관리 페이지
	 */
	@RequestMapping("/updatevehicle")
	public String updateVehicle(VehicleVO vo) {

		vehicleService.updateVehicle(vo);

		return "redirect:/vehicle";
	}

	/**
	 * 자동차 삭제 버튼 클릭시 확인후 차량 데이터 삭제
	 * 
	 * @return 자동차 관리 페이지
	 */
	@RequestMapping("/deletevehicle")
	@ResponseBody
	public String deleteVehicle(@RequestParam String modelCode) {
		JSONObject jobj = new JSONObject();

		jobj.put("flag", vehicleService.deleteVehicle(modelCode));

		return jobj.toString();
	}

}
