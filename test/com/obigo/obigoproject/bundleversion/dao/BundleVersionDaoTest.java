package com.obigo.obigoproject.bundleversion.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.bundle.bundleversion.dao.BundleVersionDao;
import com.obigo.obigoproject.bundle.bundleversion.vo.BundleVersionVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class BundleVersionDaoTest {

	@Autowired
	BundleVersionDao bundleVersionDao;

	@Test
	public void insertTest() {

		BundleVersionVO bundleVersionVO = new BundleVersionVO();
		bundleVersionVO.setBundleVersion("version");
		Assert.assertEquals(bundleVersionDao.insertBundleVersion(bundleVersionVO), 1);
	}

	@Test
	public void updateTest() {

		BundleVersionVO bundleVersionVO = new BundleVersionVO();
		bundleVersionVO.setBundleVersion("version");

		int resultCount = bundleVersionDao.updateBundleVersion(bundleVersionVO);
		Assert.assertEquals(1, resultCount);
	}

	@Test
	public void deleteTest() {
		Assert.assertEquals(bundleVersionDao.deleteBundleVersion("version"), 1);
	}

	@Test
	public void getTest() {

		BundleVersionVO bundleVersionVO = new BundleVersionVO();
		bundleVersionVO.setBundleVersion("version");

		String bundleVersion = bundleVersionDao.getBundleVersion();
		System.out.println(bundleVersion);
		Assert.assertEquals("version", bundleVersion);
	}

}
