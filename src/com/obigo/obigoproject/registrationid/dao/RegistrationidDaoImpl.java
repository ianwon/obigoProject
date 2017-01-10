package com.obigo.obigoproject.registrationid.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vo.RegistrationidVO;

@Repository("registrationidDao")
public class RegistrationidDaoImpl implements RegistrationidDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertRegistrationid(RegistrationidVO vo) {
		return sqlSession.insert("obigoproject.Registrationid.insertRegistrationid", vo);
	}

	@Override
	public List<String> getRegistrationidListByuserId(String userId) {
		return sqlSession.selectList("obigoproject.Registrationid.selectRegistrationidListByuserId", userId);
	}

	@Override
	public List<RegistrationidVO> getRegistrationidList() {
		return sqlSession.selectList("obigoproject.Registrationid.selectRegistrationidList");
	}

	@Override
	public int deleteRegistrationid(String registrationId) {
		return sqlSession.delete("obigoproject.Registrationid.deleteRegistrationid", registrationId);
	}

	@Override
	public int selectRegistrationidCount(String registrationId) {
		return sqlSession.selectOne("obigoproject.Registrationid.selectRegistrationid", registrationId);
	}

	@Override
	public int updateRegistrationid(RegistrationidVO vo) {
		return sqlSession.update("obigoproject.Registrationid.updateRegistrationid", vo);
	}

}
