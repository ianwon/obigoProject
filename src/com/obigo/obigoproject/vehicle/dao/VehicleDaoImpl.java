package com.obigo.obigoproject.vehicle.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vehicle.vo.VehicleVO;

@Repository("vehicleDao")
public class VehicleDaoImpl implements VehicleDao {
	@Autowired
	SqlSession sqlSession;

	// 차량정보 등록
	@Override
	public int insertVehicle(VehicleVO vo) {
		return sqlSession.insert("obigoproject.Vehicle.insertVehicle",vo);
	}

	// 차량정보 수정
	@Override
	public int updateVehicle(VehicleVO vo) {
		return sqlSession.update("obigoproject.Vehicle.updateVehicle", vo);
	}

	// 차량정보 삭제
	@Override
	public int deleteVehicle(String modelCode) {
		return sqlSession.delete("obigoproject.Vehicle.deleteVehicle", modelCode);
	}

	// 전체 차량 정보를 가져오는 메서드
	@Override
	public List<VehicleVO> getVehicleList() {
		return sqlSession.selectList("obigoproject.Vehicle.selectVehicleList");
	}

	// 안드로이드에서 상세보기를 할때 USER_VEHICLE과 VEHICLE을 같이 받아야 하므로 
	// USER_VEHICLE의 MODEL_CODE에 해당하는 VEHICLE 정보를 가져오는 메서드
	@Override
	public VehicleVO getVehicle(String modelCode) {
		return sqlSession.selectOne("obigoproject.Vehicle.selectVehicle", modelCode);
	}

}
