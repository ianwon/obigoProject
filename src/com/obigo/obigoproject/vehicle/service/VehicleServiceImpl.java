package com.obigo.obigoproject.vehicle.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.obigo.obigoproject.vehicle.dao.VehicleDao;
import com.obigo.obigoproject.vo.VehicleVO;

@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleDao vehicleDao;

	// 차량정보 등록
	@Override
	public boolean insertVehicle(VehicleVO vo, HttpServletRequest request) {
		int resultCount = 0;
		vo = createFile(vo, request);
		resultCount = vehicleDao.insertVehicle(vo);

		if (resultCount == 1)
			return true;
		else
			return false;
	}

	// 차량정보 수정
	@Override
	public boolean updateVehicle(VehicleVO vo, HttpServletRequest request) {
		int resultCount = 0;
		vo = createFile(vo, request);
		resultCount = vehicleDao.updateVehicle(vo);

		if (resultCount == 1)
			return true;
		else
			return false;
	}

	// 차량정보 삭제
	@Override
	public boolean deleteVehicle(String modelCode) {
		int resultCount = 0;

		resultCount = vehicleDao.deleteVehicle(modelCode);

		if (resultCount == 1)
			return true;
		else
			return false;
	}

	// 전체 차량 정보를 가져오는 메서드
	@Override
	public List<VehicleVO> getVehicleList() {

		return vehicleDao.getVehicleList();

	}

	// 안드로이드에서 상세보기를 할때 USER_VEHICLE과 VEHICLE을 같이 받아야 하므로
	// USER_VEHICLE의 MODEL_CODE에 해당하는 VEHICLE 정보를 가져오는 메서드
	@Override
	public VehicleVO getVehicle(String modelCode) {

		return vehicleDao.getVehicle(modelCode);

	}

	public VehicleVO createFile(VehicleVO vo, HttpServletRequest request) {
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		MultipartFile imageFile = multiRequest.getFile("model_Image");
		MultipartFile detailFile = multiRequest.getFile("detail_Image");
		String imagePath = "c:\\obigo\\vehicle\\image\\";
		String detailPath = "c:\\obigo\\vehicle\\detail\\";
		File imageDir = new File(imagePath);
		File detailDir = new File(detailPath);
		if (!imageDir.exists())
			imageDir.mkdirs();
		if (!detailDir.exists())
			detailDir.mkdirs();
		File imageF = new File(imagePath + imageFile.getOriginalFilename());
		File detailF = new File(detailPath + detailFile.getOriginalFilename());
		try {
			imageFile.transferTo(imageF);
			detailFile.transferTo(detailF);
		} catch (IOException e) {
			e.printStackTrace();
		}
		vo.setModelImage(imagePath);
		vo.setDetailImage(detailPath);

		return vo;
	}

}