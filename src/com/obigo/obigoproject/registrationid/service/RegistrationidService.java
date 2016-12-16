package com.obigo.obigoproject.registrationid.service;

import java.util.List;

import com.obigo.obigoproject.vo.RegistrationidVO;

public interface RegistrationidService {
	public boolean insertRegistrationid(RegistrationidVO vo);

	public List<RegistrationidVO> getRegistrationidListByuserId(String userId);
	
	public List<RegistrationidVO> getRegistrationidList();
}
