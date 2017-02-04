package com.obigo.obigoproject.log.dao;

import java.util.List;
import java.util.Map;

import com.obigo.obigoproject.log.vo.LogVO;

public interface LogDao {

	public int insertLog(LogVO vo);

	public int deleteAllLog();

	// 전체 API 가져오는 메소드
	public List<LogVO> getLogList();

	public List<LogVO> getLogListPaging(Map<String,Object> map);

	// 특정 URL API 가져오는 메소드(카테고리)
	public List<LogVO> getLogListByUrl(String url);

	public int getLogCount(String query);

	public int getMonthLogCount(Map<String, Object> map);

	public int getUserMonthLogCount(Map<String, Object> map);

	public int getBundleUpdateCount(Map<String, Object> map);
}
