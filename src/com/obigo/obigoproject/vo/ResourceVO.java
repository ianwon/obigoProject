package com.obigo.obigoproject.vo;

public class ResourceVO {
	private int resourceNumber;
	private String resourceName;
	private String path;
	private String resourceVersion;
	private String bundleKey;

	public int getResourceNumber() {
		return resourceNumber;
	}

	public void setResourceNumber(int resourceNumber) {
		this.resourceNumber = resourceNumber;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getResourceVersion() {
		return resourceVersion;
	}

	public void setResourceVersion(String resourceVersion) {
		this.resourceVersion = resourceVersion;
	}

	public String getBundleKey() {
		return bundleKey;
	}

	public void setBundleKey(String bundleKey) {
		this.bundleKey = bundleKey;
	}

	@Override
	public String toString() {
		return "ResourceVO [resourceNumber=" + resourceNumber + ", resourceName=" + resourceName + ", path=" + path
				+ ", resourceVersion=" + resourceVersion + ", bundleKey=" + bundleKey + "]";
	}

}
