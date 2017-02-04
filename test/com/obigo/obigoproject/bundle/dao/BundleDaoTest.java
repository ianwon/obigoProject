package com.obigo.obigoproject.bundle.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vo.BundleVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class BundleDaoTest {

	@Autowired
	BundleDao bundleDao;

	@Test
	public void insertBundleTest() {
		BundleVO vo = new BundleVO();
		vo.setBundleKey("key");
		vo.setBundleName("a");
		vo.setBundleVersion("0.1v");
		vo.setDeveloper("wyh");
		vo.setFileUpload("c://");
		Assert.assertEquals(bundleDao.insertBundle(vo), 1);
	}

	@Test
	public void updateBundleTest() {
		BundleVO vo = new BundleVO();
		vo.setBundleKey("key");
		vo.setBundleName("b");
		vo.setBundleVersion("0.1v");
		vo.setDeveloper("wyh");
		vo.setFileUpload("c://");
		Assert.assertEquals(bundleDao.updateBundle(vo), 1);
	}

	@Test
	public void deleteBundleTest() {
		Assert.assertEquals(bundleDao.deleteBundle("0.1v"), 1);
	}

	@Test
	public void getBundleListTest() {
		List<BundleVO> list = bundleDao.getBundleList();

		Assert.assertEquals(list.get(0).getBundleVersion(), "0.1v");

	}
}
