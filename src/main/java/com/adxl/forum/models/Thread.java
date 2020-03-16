package com.adxl.forum.models;

import javax.naming.Name;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "thread")
public class Thread {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Question question;
	@OneToMany
	@JoinColumn(name = "id")
	private List<Answer> answers;

	public Thread(){
	}

	public Thread(Question question) {
		this.question=question;
		answers=new ArrayList<>();
	}

	public Question getQuestion() {
		return question;
	}

	public int getScore() {
		return question.getScore();
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
