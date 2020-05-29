package com.br.gabriel.jobManager.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.gabriel.jobManager.model.Job;
import com.br.gabriel.jobManager.service.TaskOrganizer;

@RestController
@RequestMapping("job")
public class JobRestController {
	
	private final TaskOrganizer taskOrganizer;
	
	 public JobRestController(final TaskOrganizer organizadorDeJobs) {
		this.taskOrganizer = organizadorDeJobs;
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<List<Job>> postJobs(@RequestBody List<Job> jobs) {
		return taskOrganizer.generateNextExecutionLists(jobs); 
    }

}
