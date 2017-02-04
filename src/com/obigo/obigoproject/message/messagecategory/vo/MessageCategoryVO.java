package com.obigo.obigoproject.message.messagecategory.vo;

public class MessageCategoryVO {
	private int categoryNumber;
	private String categoryName;

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "MessageCategoryVO [categoryNumber=" + categoryNumber + ", categoryName=" + categoryName + "]";
	}

}
