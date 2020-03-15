package com.adxl.forum.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Thread {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private Question question;
	private List<Answer> answers;

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
