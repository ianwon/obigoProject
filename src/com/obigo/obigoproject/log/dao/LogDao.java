package com.obigo.obigoproject.log.dao;

import java.util.List;
import java.util.Map;

import com.obigo.obigoproject.vo.LogVO;

public interface LogDao {

	public int insertLog(LogVO vo);

	public int deleteAllLog();

	// 전체 API 가져오는 메소드
	public List<LogVO> getLogList();

	// 특정 URL API 가져오는 메소드(카테고리)
	public List<LogVO> getLogListByUrl(String url);
	
	public int getLogCount();
	
	public int getMonthLogCount(Map<String,Integer> map);
	
	public int getUserMonthLogCount(Map<String,Object> map);
	
}
