package com.adxl.forum.models;

import javax.persistence.*;

@Entity
@Table(name="question")
public class Question extends Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;

	public Question() {
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
