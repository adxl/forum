package com.adxl.forum.models;

import javax.persistence.*;

@Entity
public class Answer extends Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int answer_id;

	public Answer() {
	}

	public Answer(String text) {
		super(text);
	}
}
