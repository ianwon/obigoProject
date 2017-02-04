package com.obigo.obigoproject.androiduservehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obigo.obigoproject.androiduservehicle.dao.AndroidUserVehicleDao;
import com.obigo.obigoproject.androiduservehicle.vo.AndroidUserVehicleVO;

@Service("AndroiduservehicleService")
public class AndroidUserVehicleServiceImpl implements AndroidUserVehicleService {
	@Autowired
	AndroidUserVehicleDao androiduservehicleDao;

	@Override
	public List<AndroidUserVehicleVO> getAndroidUserVehicleListByUserid(String userId) {
		return androiduservehicleDao.getAndroidUserVehicleListByUserid(userId);
	}

}
