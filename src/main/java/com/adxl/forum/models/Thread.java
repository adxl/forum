package com.adxl.forum.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Thread {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	@OneToOne
	private Question question;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Answer> answers=new ArrayList<>();

	public Thread(){

	}

	public Thread(String questionTitle,String questionText) {
		question=new Question(questionTitle,questionText);
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

	public void addAnswer(String answerText) {
		answers.add(new Answer(answerText));
	}

	public void deleteAnswer(Answer answer) {
		answers.remove(answer);
	}
}
