package com.obigo.obigoproject.registrationid.dao;

import java.util.List;

import com.obigo.obigoproject.registrationid.vo.RegistrationidVO;

public interface RegistrationidDao {
	public int insertRegistrationid(RegistrationidVO vo);

	public List<String> getRegistrationidListByuserId(String userId);

	public List<RegistrationidVO> getRegistrationidList();

	public int deleteRegistrationid(String registrationId);

	public int selectRegistrationidCount(String registrationId);

	public int updateRegistrationid(RegistrationidVO vo);
}
