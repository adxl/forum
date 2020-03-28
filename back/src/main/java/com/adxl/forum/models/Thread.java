package com.adxl.forum.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="thread")
public class Thread {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade=CascadeType.ALL)
	private Question question;

	@JoinColumn(name="id")
	@OneToMany(cascade=CascadeType.ALL)
	private List<Answer> answers;

	public Thread() {
	}

	public Thread(Question question) {
		this.question=question;
		answers=new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public Question getQuestion() {
		return question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void addAnswer(Answer answer) {
		answers.add(answer);
	}

	public void deleteAnswer(Answer answer) {
		answers.remove(answer);
	}
}
