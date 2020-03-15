package com.adxl.forum.models;

import java.util.List;

public class Thread {

	private Question question;
	private List<Answer> answers;

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
