package com.obigo.obigoproject.log.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<LogVO> getLogList() {
		return logDao.getLogList();
	}

	@Override
	public List<LogVO> getLogListByUrl(String url) {
		return logDao.getLogListByUrl(url);
	}

	// 월단위 특정 Log 카운트 하는 메소드
	@Override
	public List<Integer> getMonthLogCount(String url, String year) {
		List<Integer> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();

		map.put("year", year);
		map.put("url", url);
		for (int i = 1; i <= 12; i++) {
			if (i < 10)
				map.put("month", "0" + i);
			else
				map.put("month", "" + i);

			list.add(logDao.getMonthLogCount(map));
		}
		return list;
	}

	// 월단위 특정 User의 특정 Log 카운트 하는 메소드
	public List<Integer> getUserMonthLogCount(String selectYear, String url, String userId) {
		List<Integer> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("year", selectYear);
		map.put("url", url);
		map.put("body", userId);

		for (int i = 1; i <= 12; i++) {
			if (i < 10)
				map.put("month", "0" + i);
			else
				map.put("month", i + "");
			list.add(logDao.getUserMonthLogCount(map));
		}
		return list;
	}

	public List<Integer> getBundleUpdateCount() {
		List<Integer> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		Calendar cal = Calendar.getInstance();
		map.put("year", new Integer(cal.get(Calendar.YEAR) - 2000));
		int month = cal.get(Calendar.MONTH) + 1;
		for (int i = 0; i < 8; i++) {
			if (month == 0) {
				map.put("year", new Integer(cal.get(Calendar.YEAR) - 2000 - 1));
				month = 12;
			}
			map.put("month", month);
			list.add(logDao.getBundleUpdateCount(map));
			month--;
		}

		return list;
	}

	static int pageSize = 15;

	@Override
	public List<LogVO> getLogListPaging(int page) {
		int logCount = logDao.getLogCount();
		Map<String, Integer> map = new HashMap<>();
		map.put("endNum", pageSize * page);
		map.put("startNum", map.get("endNum") - pageSize + 1);
		if (logCount < map.get("startNum"))
			map.put("startNum", logCount);
		return logDao.getLogListPaging(map);
	}

	@Override
	public List<Integer> getPageList(int page) {
		List<Integer> list = new ArrayList<>();
		int logCount = logDao.getLogCount();
		int start = 0;
		int endNum = 0;

		if (logCount % pageSize > 0)
			endNum = (logCount / pageSize) + 1;
		else
			endNum = logCount / pageSize;

		if (page < 6) {
			start = 1;
		} else {
			if (endNum - 9 < page)
				start = endNum - 9;
			else
				start = page - 5;
		}

		for (int i = 0; i < 10; i++) {
			list.add(start++);
		}

		return list;
	}

	@Override
	public int getEndPageNum() {
		int count = logDao.getLogCount();
		int endPageNum = 0;
		if (count / pageSize == 0)
			endPageNum = count / pageSize;
		else
			endPageNum = (count / pageSize) + 1;
		return endPageNum;
	}

}