package com.adxl.forum.models;

import org.hibernate.type.DateType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
public class Post {

	@Column(length=100000)
	private String text;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public Post() {
		date=new Date();
	}

	public Post(String text) {
		this.text=text;
		date=Calendar.getInstance().getTime();
		//		System.out.println(date);
		//		System.out.println(text);
	}

	public String getText() {
		return text;
	}


	public Date getDate() {
		return date;
	}
}
