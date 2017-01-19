package com.obigo.obigoproject.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obigo.obigoproject.util.obigoUtils;
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
	 * 동일한 Model Code가 체크하는 Api parameter = "modelCode":차량의 model code
	 * 
	 * @return true/false : 동일한 Model Code가 존재하는지 여부
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
	@RequestMapping(value = "/updatevehicle", method = RequestMethod.POST)
	public String updateVehicle(VehicleVO vo, HttpServletRequest request) {

		vehicleService.updateVehicle(vo, request);

		return "redirect:/vehicle";
	}

	/**
	 * 특정 차량 정보 가져오는 메서드 parameter = "modelCode":차량의 model code
	 * 
	 * @return JSON : Vehicle VO를 JSON data로 return
	 */
	@RequestMapping(value = "/selectvehicle", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String selectVehicle(@RequestParam("modelCode") String modelCode, Model model) {
		JSONObject jobj = new JSONObject();
		jobj.put("vehicle", vehicleService.getVehicle(modelCode));

		return jobj.toString();
	}

	/**
	 * 차량 정보를 삭제하는 메서드 parameter = "modelCode":차량의 model code
	 * 
	 * @return true/false : 차량 정보 삭제 성공 여부
	 */
	@RequestMapping("/deletevehicle")
	@ResponseBody
	public String deleteVehicle(@RequestParam String modelCode) {
		JSONObject jobj = new JSONObject();

		jobj.put("flag", vehicleService.deleteVehicle(modelCode));

		return jobj.toString();
	}

	/**
	 * 차량 이미지를 보여주기위한 메소드 parameter = "modelImage":차량의 Image file name
	 * 
	 * @return HttpServletResponse : Image를 response에 담아서 보내줌
	 */
	@RequestMapping("/vehicleImage")
	public void vehicleImage(@RequestParam("modelImage") String modelImage, HttpServletResponse response) {
		String path = obigoUtils.path + "vehicle" + File.separator;
		path += modelImage;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(path);
			byte[] iconImage = new byte[fs.available()];
			fs.read(iconImage);
			response.setContentType("image/jpg");
			response.getOutputStream().write(iconImage);
		} catch (Exception e1) {
			try {
				fs = new FileInputStream(obigoUtils.path + "no_car.png");
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

}