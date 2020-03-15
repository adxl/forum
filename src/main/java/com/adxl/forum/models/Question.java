package com.adxl.forum.models;

public class Question extends Post {

	private String title;

	public Question(String title,String text) {
		super(text);
		this.title=title;
	}

	public String getTitle() {
		return title;
	}
}
