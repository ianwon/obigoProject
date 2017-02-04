package com.obigo.obigoproject.vo;

public class VehicleVO {
	private String modelName;
	private String modelCode;
	private String modelImage;
	private String detailImage;
	private String engine;
	private int modelYear;
	private String mileage;

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getModelImage() {
		return modelImage;
	}

	public void setModelImage(String modelImage) {
		this.modelImage = modelImage;
	}

	public String getDetailImage() {
		return detailImage;
	}

	public void setDetailImage(String detailImage) {
		this.detailImage = detailImage;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "VehicleVO [modelName=" + modelName + ", modelCode=" + modelCode + ", modelImage=" + modelImage + ", detailImage=" + detailImage +  ", engine=" + engine + ", modelYear=" + modelYear + ", mileage="
				+ mileage + "]";
	}

}
