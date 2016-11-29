package com.obigo.obigoproject.vo;

public class BundleVO {
	private String bundleName;
	private String bundleVersion;
	private String fileUpload;
	private String developer;
	private String bundleKey;

	public String getBundleName() {
		return bundleName;
	}

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	public String getBundleVersion() {
		return bundleVersion;
	}

	public void setBundleVersion(String bundleVersion) {
		this.bundleVersion = bundleVersion;
	}

	public String getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getBundleKey() {
		return bundleKey;
	}

	public void setBundleKey(String bundleKey) {
		this.bundleKey = bundleKey;
	}

	@Override
	public String toString() {
		return "BundleVO [bundleName=" + bundleName + ", bundleVersion=" + bundleVersion + ", fileUpload=" + fileUpload
				+ ", developer=" + developer + ", bundleKey=" + bundleKey + "]";
	}

}
