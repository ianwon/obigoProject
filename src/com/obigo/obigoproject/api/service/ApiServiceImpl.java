package com.obigo.obigoproject.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obigo.obigoproject.api.dao.ApiDao;
import com.obigo.obigoproject.vo.ApiVO;

@Service("apiService")
public class ApiServiceImpl implements ApiService {
	@Autowired
	ApiDao apiDao;

	@Override
	public boolean insertApi(ApiVO vo) {
		int result = apiDao.insertApi(vo);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateApi(ApiVO vo) {
		int result = apiDao.updateApi(vo);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteApi(String apiName) {
		int result = apiDao.deleteApi(apiName);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<ApiVO> getApiList() {
		return apiDao.getApiList();
	}

	@Override
	public ApiVO getApi(String apiName) {
		return apiDao.getApi(apiName);
	}

}
