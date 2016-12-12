package com.obigo.obigoproject.vehicle.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.obigo.obigoproject.vo.VehicleVO;

public interface VehicleService {

	// 차량정보 등록
	public boolean insertVehicle(VehicleVO vo, HttpServletRequest request);

	// 차량정보 수정
	public boolean updateVehicle(VehicleVO vo, HttpServletRequest request);

	// 차량정보 삭제
	public boolean deleteVehicle(String modelCode);

	// 전체 차량 정보를 가져오는 메서드
	public List<VehicleVO> getVehicleList();

	// 안드로이드에서 상세보기를 할때 USER_VEHICLE과 VEHICLE을 같이 받아야 하므로 
	// USER_VEHICLE의 MODEL_CODE에 해당하는 VEHICLE 정보를 가져오는 메서드
	public VehicleVO getVehicle(String modelCode);

}