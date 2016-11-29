package com.obigo.obigoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.obigo.obigoproject.bundle.service.BundleService;
import com.obigo.obigoproject.bundleversion.service.BundleVersionService;
import com.obigo.obigoproject.vo.BundleVO;

@Controller
public class BundleController {
	@Autowired
	BundleService bundleService;
	@Autowired
	BundleVersionService bundleVersionService;

	/**
	 * 등록된 번들중 한개 선택후 적용 버튼 클릭시 해당 번들을 번들 버전으로 적용
	 * 
	 * @return 번들 관리 페이지
	 */
	@RequestMapping("/applybundle")
	public String applyBundle(@RequestParam String bundleVersion) {
		return null;
	}

	/**
	 * 번들 등록 폼에서 등록 버튼 클릭시 번들을 등록
	 * 
	 * @return 번들 관리 페이지
	 */
	@RequestMapping("/insertbundle")
	public String insertBundle(@RequestParam BundleVO vo) {
		return null;
	}

	/**
	 * 번들 수정 폼에서 수정 버튼 클릭시 번들을 수정
	 * 
	 * @return 번들 관리 페이지
	 */
	@RequestMapping("/updatebundle")
	public String updateBundle(@RequestParam BundleVO vo) {
		return null;
	}

	/**
	 * 번들 관리 페이지에서 번들 삭제 버튼 클릭시 해당 번들을 삭제
	 * 
	 * @return 번들 관리 페이지
	 */
	@RequestMapping("/deletebundle")
	public String deleteBundle(@RequestParam String bundleVersion) {
		return null;
	}


}
