package com.obigo.obigoproject.androiduservehicle.dao;

import java.util.List;

import com.obigo.obigoproject.vo.AndroidUserVehicleVO;

public interface AndroidUserVehicleDao {
public List<AndroidUserVehicleVO> getAndroidUserVehicleListByUserid(String userId);
}
