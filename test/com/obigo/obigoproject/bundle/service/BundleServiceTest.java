package com.obigo.obigoproject.bundle.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.vo.BundleVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class BundleServiceTest {

	@Autowired
	BundleService bundleService;

	@Test
	public void insertBundleTest() {
		BundleVO vo = new BundleVO();
		vo.setBundleKey("bk");
		vo.setBundleName("smaple");
		vo.setBundleVersion("0.001");
		vo.setDeveloper("wyhZzang");
		vo.setFileUpload("C://hi//");
		Assert.assertTrue(bundleService.insertBundle(vo));
	}

	@Test
	public void updateBundleTest() {
		BundleVO vo = new BundleVO();
		vo.setBundleKey("bk");
		vo.setBundleName("sample");
		vo.setBundleVersion("0.001");
		vo.setDeveloper("wyhZzang");
		vo.setFileUpload("C://hi//");
		bundleService.updateBundle(vo);
		Assert.assertTrue(bundleService.updateBundle(vo));
	}

	@Test
	public void deleteBundleTest() {
		Assert.assertTrue(bundleService.deleteBundle("0.001"));
	}

	@Test
	public void getBundleListTest() {
		Assert.assertEquals(bundleService.getBundleList().size(), 2);
	}

	// 번들 한개 가져오는것도 필요할 것 같아서 만들어봤어.
	@Test
	public void getBundleTest() {
		Assert.assertEquals(bundleService.getBundle("0.001").getBundleName(), "sample");
	}

}
