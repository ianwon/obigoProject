package com.obigo.obigoproject.user.uservehicle.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.message.pushmessage.vo.PushMessageVO;
import com.obigo.obigoproject.user.uservehicle.vo.UserVehicleVO;

@Repository("userVehicleDao")
public class UserVehicleDaoImpl implements UserVehicleDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertUserVehicle(UserVehicleVO vo) {
		return sqlSession.insert("obigoproject.UserVehicle.insertUserVehicle", vo);
	}

	@Override
	public int updateUserVehicle(UserVehicleVO vo) {
		return sqlSession.update("obigoproject.UserVehicle.updateUserVehicle", vo);
	}

	@Override
	public int deleteUserVehicle(int userVehicleNumber) {
		return sqlSession.delete("obigoproject.UserVehicle.deleteUserVehicle", userVehicleNumber);
	}

	@Override
	public List<UserVehicleVO> getUserVehicleList(String userId) {
		return sqlSession.selectList("obigoproject.UserVehicle.selectUserVehicleList", userId);
	}

	@Override
	public UserVehicleVO getUserVehicle(int userVehicleNumber) {
		return sqlSession.selectOne("obigoproject.UserVehicle.selectUserVehicle", userVehicleNumber);
	}

	@Override
	public List<String> getLocation() {
		return sqlSession.selectList("obigoproject.UserVehicle.selectLocation");
	}

	@Override
	public List<String> getUserId(PushMessageVO vo) {
		return sqlSession.selectList("obigoproject.UserVehicle.selectUserId", vo);
	}

	@Override
	public int getUserVehicleCount() {
		return sqlSession.selectOne("obigoproject.UserVehicle.selectUserVehicleCount");
	}

	// 차량 모델별 User가 가지고 있는 수를 카운트해서 가져오는 메소드
	@Override
	public List<Map<String, Object>> getCountingByModelName() {
		return sqlSession.selectList("obigoproject.UserVehicle.selectCountingByModelName");
	}

	@Override
	public int checkVinNumber(String vin) {
		return sqlSession.selectOne("obigoproject.UserVehicle.checkVinNumber", vin);
	}

}
