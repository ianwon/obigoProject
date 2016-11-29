package com.obigo.obigoproject.log.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vo.LogVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class LogDaoTest {

	@Autowired
	LogDao logDao;

	@Test
	public void insertTest() {

		LogVO logVO = new LogVO();
		int resultCount = 0;

		logVO.setDateTime("date");
		logVO.setReturned("retured data");
		logVO.setUrl("/tods/api/vhcllst");
		logVO.setBody("log body");

		resultCount += logDao.insertLog(logVO);

		logVO.setDateTime("date2");
		logVO.setReturned("retured data2");
		logVO.setUrl("/tods/api/vhcllst");
		logVO.setBody("log body2");

		resultCount += logDao.insertLog(logVO);

		logVO.setDateTime("date3");
		logVO.setReturned("retured data3");
		logVO.setUrl("/tods/api/lgn");
		logVO.setBody("log body3");

		resultCount += logDao.insertLog(logVO);

		Assert.assertEquals(3, resultCount);

	}

	@Test
	public void selectListTest() {

		Assert.assertEquals(3, logDao.getLogList().size());

	}

	@Test
	public void selectByUrlTest() {

		Assert.assertEquals(2, logDao.getLogListByUrl("/tods/api/vhcllst").size());

	}

	@Test
	public void deleteTest() {

		Assert.assertEquals(3, logDao.deleteAllLog());

	}

	@Test
	public void getLogCountTest() {

		Assert.assertEquals(3, logDao.getLogCount());

	}

}
