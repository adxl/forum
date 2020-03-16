package com.adxl.forum.controllers;

import com.adxl.forum.models.Question;
import com.adxl.forum.models.Thread;
import com.adxl.forum.repositories.ThreadRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThreadsController {

	private final ThreadRepository threadRepository;

	public ThreadsController(ThreadRepository threadRepository) {
		this.threadRepository=threadRepository;
	}

	@ResponseBody
	@GetMapping(path="/q/all")
	public Iterable<Thread> getAllThreads() {
		return threadRepository.findAll();
	}

	@PostMapping("/q/new")
	public void createThread(@RequestParam Question question){
		Thread thread = new Thread(question);
		threadRepository.save(thread);
	}
	

}
