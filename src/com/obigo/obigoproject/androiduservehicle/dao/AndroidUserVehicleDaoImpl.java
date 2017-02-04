package com.obigo.obigoproject.androiduservehicle.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.androiduservehicle.vo.AndroidUserVehicleVO;

@Repository("androidUserVehicleDao")
public class AndroidUserVehicleDaoImpl implements AndroidUserVehicleDao {

	@Autowired
	SqlSession sqlSession;
	@Override
	public List<AndroidUserVehicleVO> getAndroidUserVehicleListByUserid(String userId) {
		return sqlSession.selectList("obigoproject.AndroidUserVehicle.selectAndroidUserVehicle", userId);
	}
}
