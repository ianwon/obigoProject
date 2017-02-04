package com.obigo.obigoproject.log.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vo.LogVO;

/*
 * Log DB에서 Log 데이터를 입력, 수정, 삭제, 리스트 호출등
 * Log DB와 접근하기 위한 LogClass  
 */
@Repository("logDao")
public class LogDaoImpl implements LogDao {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertLog(LogVO vo) {
		return sqlSession.insert("obigoproject.Log.insertLog", vo);
	}

	@Override
	public int deleteAllLog() {
		return sqlSession.delete("obigoproject.Log.deleteAllLog");
	}

	// 전체 API 가져오는 메소드
	@Override
	public List<LogVO> getLogList() {
		return sqlSession.selectList("obigoproject.Log.selectLog");
	}

	// 특정 URL API 가져오는 메소드(카테고리)
	@Override
	public List<LogVO> getLogListByUrl(String url) {
		return sqlSession.selectList("obigoproject.Log.selectLogByUrl", url);
	}

	// 통계치를 위한 전체 Log의 수를 가져오기 위한 메소드
	@Override
	public int getLogCount(String query) {
		Map<String, String> map = new HashMap<>();
		map.put("query", query);
		return sqlSession.selectOne("obigoproject.Log.selectLogCount", map);
	}

	@Override
	public int getMonthLogCount(Map<String, Object> map) {
		return sqlSession.selectOne("obigoproject.Log.selectMonthLogCount", map);
	}

	@Override
	public int getUserMonthLogCount(Map<String, Object> map) {
		return sqlSession.selectOne("obigoproject.Log.selectUserMonthLogCount", map);
	}

	// 사용자의 번들 업데이트 횟수를 구하는 메소드
	@Override
	public int getBundleUpdateCount(Map<String, Object> map) {
		return sqlSession.selectOne("obigoproject.Log.selectBundleUpdateCount", map);
	}

	@Override
	public List<LogVO> getLogListPaging(Map<String, Object> map) {
		return sqlSession.selectList("obigoproject.Log.selectLogListPaging", map);
	}

	@Override
	public List<LogVO> getLogList(String date) {
		return sqlSession.selectList("obigoproject.Log.selectBundleListDate", date);
	}

}
