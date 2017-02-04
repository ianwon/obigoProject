package com.obigo.obigoproject.androiduservehicle.service;

import java.util.List;

import com.obigo.obigoproject.androiduservehicle.vo.AndroidUserVehicleVO;

public interface AndroidUserVehicleService {
	public List<AndroidUserVehicleVO> getAndroidUserVehicleListByUserid(String userId);
}
