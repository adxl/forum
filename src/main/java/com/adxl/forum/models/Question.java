package com.adxl.forum.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question extends Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;

	public Question(){
		super();
	}

	public Question(String title,String text) {
		super(text);
		this.title=title;
	}

	public String getTitle() {
		return title;
	}
}
