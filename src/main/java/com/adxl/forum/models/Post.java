package com.adxl.forum.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class Post {

	@Column(length=100000)
	private String text;
	private Date date;

	public Post() {
	}

	public Post(String text) {
		this.text=text;
		date=new Date();
	}

	public String getText() {
		return text;
	}

	public Date getDate() {
		return date;
	}
}
