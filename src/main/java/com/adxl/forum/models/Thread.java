package com.adxl.forum.models;

import java.util.List;

public class Thread {

	private Post question;
	private List<Post> answers;

	public Thread(String questionText) {
		question=new Post(questionText);
	}

	public Post getQuestion() {
		return question;
	}

	public int getScore() {
		return question.getScore();
	}

	public List<Post> getAnswers() {
		return answers;
	}

	public void addAnswer(String answerText) {
		answers.add(new Post(answerText));
	}

	public void deleteAnswer(Post answer) {
		answers.remove(answer);
	}
}
