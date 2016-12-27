package com.obigo.obigoproject.log.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obigo.obigoproject.vo.LogVO;

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

	@Override
	public List<LogVO> getLogList() {
		return sqlSession.selectList("obigoproject.Log.selectLog");
	}

	@Override
	public List<LogVO> getLogListByUrl(String url) {
		return sqlSession.selectList("obigoproject.Log.selectLogByUrl", url);
	}

	@Override
	public int getLogCount() {
		return sqlSession.selectOne("obigoproject.Log.selectLogCount");
	}

	@Override
	public int getMonthLogCount(Map<String,Integer> map) {
		return sqlSession.selectOne("obigoproject.Log.selectMonthLogCount", map);
	}
	
	@Override
	public int getUserMonthLogCount(Map<String,Object> map){
		return sqlSession.selectOne("obigoproject.Log.selectUserMonthLogCount", map);
	}

}
