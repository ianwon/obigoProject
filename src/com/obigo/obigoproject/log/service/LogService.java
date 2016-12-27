package com.obigo.obigoproject.log.service;

import java.util.List;

import com.obigo.obigoproject.vo.LogVO;

public interface LogService {
	public boolean insertLog(LogVO vo);

	public boolean deleteAllLog();

	// 로그 내용을 이메일 발송, 혹은 pdf형태로 출력
	public boolean sendEmail(List<LogVO> list);

	// 전체 API 가져오는 메소드
	public List<LogVO> getLogList();

	// 특정 URL API 가져오는 메소드(카테고리)
	public List<LogVO> getLogListByUrl(String url);

	//전체 로그의 특정 url값에 접근한 로그의 횟수 추출
	public List<Integer> getMonthLogCount(String url);

	//특정 유저 로그의 특정 url값에 접근한 로그의 횟수 추출
	public List<Integer> getUserMonthLogCount(String url, String userId);

	//번들 업데이트 로그의 횟수 추출
	public List<Integer> getBundleUpdateCount();
}