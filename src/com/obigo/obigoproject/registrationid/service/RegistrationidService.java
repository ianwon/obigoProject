package com.obigo.obigoproject.registrationid.service;

import java.util.List;

import com.obigo.obigoproject.registrationid.vo.RegistrationidVO;

public interface RegistrationidService {
	public boolean insertRegistrationid(RegistrationidVO vo);

	public List<String> getRegistrationidListByuserId(String userId);
	
	public List<RegistrationidVO> getRegistrationidList();
	
	public boolean deleteRegistrationid(String registrationId);
}
