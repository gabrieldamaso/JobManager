package com.br.gabriel.jobManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.gabriel.jobManager.model.Job;
import com.br.gabriel.jobManager.service.TaskOrganizer;

@RestController
@RequestMapping("job")
public class JobRestController {
	
	@Autowired
	TaskOrganizer organizadorDeJobs;
	
	@PostMapping(value = "/", produces = "application/json")
    public List<List<Job>> postJobs(@RequestBody List<Job> jobs) {
		return organizadorDeJobs.generateNextExecutionLists(jobs); 
    }

}
