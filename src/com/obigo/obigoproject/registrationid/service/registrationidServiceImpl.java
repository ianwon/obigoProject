package com.obigo.obigoproject.registrationid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obigo.obigoproject.registrationid.dao.RegistrationidDao;
import com.obigo.obigoproject.vo.RegistrationidVO;

@Service("registrationidService")
public class registrationidServiceImpl implements RegistrationidService {
	@Autowired
	RegistrationidDao registrationidDao;

	@Override
	public boolean insertRegistrationid(RegistrationidVO vo) {
		int resultCount = 0;

		resultCount = registrationidDao.insertRegistrationid(vo);

		if (resultCount == 1)
			return true;
		else
			return false;

	}

	@Override
	public List<RegistrationidVO> getRegistrationidListByuserId(String userId) {
		return registrationidDao.getRegistrationidListByuserId(userId);
	}

	@Override
	public List<RegistrationidVO> getRegistrationidList() {
		return registrationidDao.getRegistrationidList();
	}

}
