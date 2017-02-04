package com.obigo.obigoproject.bundleversion.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.obigo.obigoproject.bundle.bundleversion.service.BundleVersionService;
import com.obigo.obigoproject.bundle.bundleversion.vo.BundleVersionVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class BundleVersionServiceTest {
	@Autowired
	BundleVersionService bundleVersionService;

	@Test
	public void insertBundleVersionTest() {
		BundleVersionVO vo = new BundleVersionVO();
		vo.setBundleVersion("version");
		Assert.assertTrue(bundleVersionService.insertBundleVersion(vo));
	}

	// 컬럼 추가 안되면 String bundleVersion으로 받아도 가능예정
	@Test
	public void updateBundleVersionTest() {
		BundleVersionVO vo = new BundleVersionVO();
		vo.setBundleVersion("0.12");
		Assert.assertTrue(bundleVersionService.updateBundleVersion(vo));

	}

	@Test
	public void deleteBundleVersionTest() {
		Assert.assertTrue(bundleVersionService.deleteBundleVersion("0.12"));
	}

	@Test
	public void getBundleVersionTest() {
		Assert.assertEquals(bundleVersionService.getBundleVersion(), "0.12");
	}

}
