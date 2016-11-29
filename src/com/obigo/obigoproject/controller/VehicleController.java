package com.obigo.obigoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.obigo.obigoproject.vehicle.service.VehicleService;
import com.obigo.obigoproject.vo.VehicleVO;

@Controller
public class VehicleController {
	@Autowired
	VehicleService vehicleService;

	/**
	 * 자동차 등록폼에서 자동차 등록 버튼 클릭시 차량 등록
	 * 
	 * @return 자동차 관리 페이지
	 */
	@RequestMapping("/insertvehicle")
	public String insertVehicle(@RequestParam VehicleVO vo) {
		return null;
	}

	/**
	 * 자동차 수정폼에서 자동차 수정 버튼 클릭시 차량 수정
	 * 
	 * @return 자동차 관리 페이지
	 */
	@RequestMapping("/updatevehicle")
	public String updateVehicle(@RequestParam VehicleVO vo) {
		return null;
	}

	/**
	 * 자동차 삭제 버튼 클릭시 확인후 차량 데이터 삭제
	 * 
	 * @return 자동차 관리 페이지
	 */
	@RequestMapping("/deletevehicle")
	public String deleteVehicle(@RequestParam String modelCode) {
		return null;
	}

}
