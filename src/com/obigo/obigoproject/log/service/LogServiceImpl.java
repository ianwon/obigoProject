package com.obigo.obigoproject.log.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obigo.obigoproject.log.dao.LogDao;
import com.obigo.obigoproject.vo.LogVO;

@Service("logService")
public class LogServiceImpl implements LogService {
	@Autowired
	LogDao logDao;

	@Override
	public boolean insertLog(LogVO vo) {
		int result = logDao.insertLog(vo);
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteAllLog() {
		int count = logDao.getLogCount();
		int result = logDao.deleteAllLog();
		if (result == count)
			return true;
		else
			return false;
	}

	// 미구현
	@Override
	public boolean sendEmail(List<LogVO> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LogVO> getLogList() {
		return logDao.getLogList();
	}

	@Override
	public List<LogVO> getLogListByUrl(String url) {
		return logDao.getLogListByUrl(url);
	}

}
