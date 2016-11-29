package com.obigo.obigoproject.vehicle.dao;

import java.util.List;

import com.obigo.obigoproject.vo.VehicleVO;

public interface VehicleDao {

	// 차량정보 등록
	public int insertVehicle(VehicleVO vo);

	// 차량정보 수정
	public int updateVehicle(VehicleVO vo);

	// 차량정보 삭제
	public int deleteVehicle(String modelCode);

	// 전체 차량 정보를 가져오기 위함
	public List<VehicleVO> getVehicleList();

	// 안드로이드에서 상세보기를 할때 USER_VEHICLE과 VEHICLE을 같이 받아야 하므로 
	// USER_VEHICLE의 MODEL_CODE에 해당하는 VEHICLE 정보를 가져오는 메서드
	public VehicleVO getVehicle(String modelCode);
}
