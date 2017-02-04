package com.obigo.obigoproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obigo.obigoproject.bundle.bundle.service.BundleService;
import com.obigo.obigoproject.bundle.bundle.vo.BundleVO;
import com.obigo.obigoproject.bundle.bundleversion.service.BundleVersionService;
import com.obigo.obigoproject.bundle.bundleversion.vo.BundleVersionVO;

import net.sf.json.JSONObject;

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
	@RequestMapping(value = "/applybundle", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String applyBundle(@RequestParam("bundleVersion") String bundleVersion) {
		JSONObject jobj = new JSONObject();
		BundleVersionVO vo = new BundleVersionVO();
		vo.setBundleVersion(bundleVersion);
		if (bundleVersionService.getBundleVersion() == null) {
			bundleVersionService.insertBundleVersion(vo);
		} else
			bundleVersionService.updateBundleVersion(vo);
		return jobj.toString();
	}

	/**
	 * 번들 등록 폼에서 등록 버튼 클릭시 번들을 등록
	 * 
	 * @return 번들 관리 페이지
	 */
	@RequestMapping(value = "/insertbundle", method = RequestMethod.POST)
	public String insertBundle(BundleVO vo, HttpServletRequest request) {
		bundleService.insertBundle(vo, request);
		return "redirect:/bundle";
	}

	/**
	 * 번들 수정 폼에서 수정 버튼 클릭시 번들을 수정
	 * 
	 * @return 번들 관리 페이지
	 */
	@RequestMapping("/updatebundle")
	public String updateBundle(BundleVO vo) {
		bundleService.updateBundle(vo);
		return "redirect:/bundle";
	}

	/**
	 * 번들 관리 페이지에서 번들 삭제 버튼 클릭시 해당 번들을 삭제
	 * 
	 * @return 번들 관리 페이지
	 */
	@RequestMapping(value = "/deletebundle", method = RequestMethod.POST)
	@ResponseBody
	public String deleteUser(String bundleVersion) {
		JSONObject jobj = new JSONObject();
		if (bundleVersion.equals(bundleVersionService.getBundleVersion())) {
			jobj.put("flag", false);
			return jobj.toString();
		} else {
			bundleService.deleteBundle(bundleVersion);
			jobj.put("flag", true);
			return jobj.toString();
		}
	}

	/**
	 * 입력한 BundleVersion이 Bundle DB에 존재하는지 여부를 확인하는 메소드
	 * 
	 * @return 존재: False 미존재: True
	 */
	@RequestMapping(value = "/bundleversioncheck", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String bundleversionCheck(@RequestParam("bundleVersion") String bundleVersion) {
		JSONObject jobj = new JSONObject();
		bundleVersion=bundleVersion.trim();
		BundleVO vo = bundleService.getBundleBybundleVersion(bundleVersion);
		
		if (vo != null) {
			jobj.put("flag", false);
			return jobj.toString();
		} else {
			jobj.put("flag", true);
			return jobj.toString();
		}
	}

	/**
	 * 입력한 BundleKey가 Bundle DB에 존재하는지 여부를 확인하는 메소드
	 * 
	 * @return 존재: False 미존재: True
	 */
	@RequestMapping(value = "/bundlekeycheck", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String bundlekeyCheck(@RequestParam("bundleKey") String bundleKey) {
		JSONObject jobj = new JSONObject();
		bundleKey=bundleKey.trim();
		BundleVO vo = bundleService.getBundleBybundleKey(bundleKey);
		
		if (vo != null) {
			jobj.put("flag", false);
			return jobj.toString();
		} else {
			jobj.put("flag", true);
			return jobj.toString();
		}
	}
}
