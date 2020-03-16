package com.adxl.forum.models;

import javax.persistence.*;

@Entity
@Table(name="answer")
public class Answer extends Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	public Answer() {
	}

	public Answer(String text) {
		super(text);
	}
}
