package com.obigo.obigoproject.uservehicle.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vo.PushMessageVO;
import com.obigo.obigoproject.vo.UserVehicleVO;

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
	
	@Override
	public List<Map<String, Object>> getCountingByModelName(){
		return sqlSession.selectList("obigoproject.UserVehicle.selectCountingByModelName");
	}

}
