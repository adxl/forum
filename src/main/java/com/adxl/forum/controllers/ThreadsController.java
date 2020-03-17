package com.adxl.forum.controllers;

import com.adxl.forum.models.Answer;
import com.adxl.forum.models.Question;
import com.adxl.forum.models.Thread;
import com.adxl.forum.repositories.AnswerRepository;
import com.adxl.forum.repositories.QuestionRepository;
import com.adxl.forum.repositories.ThreadRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ThreadsController {

	private final ThreadRepository threadRepository;
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;

	public ThreadsController(ThreadRepository threadRepository,QuestionRepository questionRepository,AnswerRepository answerRepository) {
		this.threadRepository=threadRepository;
		this.questionRepository=questionRepository;
		this.answerRepository=answerRepository;
	}

	@ResponseBody
	@GetMapping(path="/q/")
	public Iterable<Thread> getAllThreads() {
		return threadRepository.findAll();
	}

	@ResponseBody
	@GetMapping("/q/{q_id}")
	public Thread getThread(@PathVariable int q_id) {
		return threadRepository.findById(q_id).get();
	}

	@ResponseBody
	@GetMapping("/q/{q_id}/a/")
	public Iterable<Answer> getAllAnswers(@PathVariable int q_id) {
		return threadRepository.findById(q_id).get().getAnswers();
	}

	@ResponseBody
	@PostMapping("/q/new")
	public void ask(@RequestBody Question question) {
		Thread thread=new Thread(question);
		questionRepository.save(question);
		threadRepository.save(thread);
	}

	@ResponseBody
	@PostMapping("/q/{q_id}/a/new")
	public void reply(@PathVariable int q_id,@RequestBody Answer answer) {
		Thread thread=threadRepository.findById(q_id).get();
		thread.addAnswer(answer);
		answerRepository.save(answer);
		threadRepository.save(thread);
	}

	@ResponseBody
	@DeleteMapping("/q/{q_id}/delete")
	public void deleteQuestion(@PathVariable int q_id) {
		threadRepository.deleteById(q_id);
	}

	@ResponseBody
	@DeleteMapping("/q/{q_id}/a/{a_id}/delete")
	public void deleteAnswer(@PathVariable int q_id, @PathVariable int a_id) {
		Thread thread = threadRepository.findById(q_id).get();
		Answer answer = answerRepository.findById(a_id).get();
		thread.deleteAnswer(answer);
		answerRepository.delete(answer);
		threadRepository.save(thread);
	}
}
