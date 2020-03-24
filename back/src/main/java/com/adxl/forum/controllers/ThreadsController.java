package com.adxl.forum.controllers;

import com.adxl.forum.models.Answer;
import com.adxl.forum.models.Question;
import com.adxl.forum.models.Thread;
import com.adxl.forum.repositories.AnswerRepository;
import com.adxl.forum.repositories.QuestionRepository;
import com.adxl.forum.repositories.ThreadRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class ThreadsController {

	private final ThreadRepository threadRepository;
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;

	public ThreadsController(ThreadRepository threadRepository,QuestionRepository questionRepository,AnswerRepository answerRepository) {
		this.threadRepository=threadRepository;
		this.questionRepository=questionRepository;
		this.answerRepository=answerRepository;
	}

	@GetMapping(path="/q/")
	public Iterable<Thread> getAllThreads() {
		return threadRepository.findAll();
	}


	@GetMapping("/q/{q_id}")
	public Optional<Thread> getThread(@PathVariable int q_id) {
		return threadRepository.findById(q_id);
	}


	@GetMapping("/q/{q_id}/a/")
	public Iterable<Answer> getAllAnswers(@PathVariable int q_id) {
		var optionalThread=threadRepository.findById(q_id);

		//noinspection OptionalIsPresent
		if(optionalThread.isPresent())
			return optionalThread.get().getAnswers();
		return null;
	}


	@PostMapping("/q/new")
	public void ask(@RequestBody Question question) {
		Thread thread=new Thread(question);
		questionRepository.save(question);
		threadRepository.save(thread);
	}


	@PostMapping("/q/{q_id}/a/new")
	public void reply(@PathVariable int q_id,@RequestBody Answer answer) {
		var optionalThread=threadRepository.findById(q_id);
		if(optionalThread.isPresent())
		{
			optionalThread.get().addAnswer(answer);
			answerRepository.save(answer);
			threadRepository.save(optionalThread.get());
		}
	}


	@DeleteMapping("/q/{q_id}/delete")
	public void deleteQuestion(@PathVariable int q_id) {
		if(threadRepository.findById(q_id).isPresent())
			threadRepository.deleteById(q_id);
	}


	@DeleteMapping("/q/{q_id}/a/{a_id}/delete")
	public void deleteAnswer(@PathVariable int q_id,@PathVariable int a_id) {
		var optionalThread=threadRepository.findById(q_id);
		var optionalAnswer=answerRepository.findById(a_id);

		if(optionalThread.isPresent() && optionalAnswer.isPresent())
		{
			optionalThread.get().deleteAnswer(optionalAnswer.get());
			answerRepository.delete(optionalAnswer.get());
			threadRepository.save(optionalThread.get());
		}
	}
}

