package com.br.gabriel.jobManager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.gabriel.jobManager.model.Job;
import com.br.gabriel.jobManager.service.TaskOrganizer;

@Validated
@RestController
@RequestMapping("job")
public class JobRestController {

	@ExceptionHandler({ ConstraintViolationException.class, HttpMessageNotReadableException.class })
	public void springHandleNotFound(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(),"please put the correct parameters in the request");
		
	}

	private final TaskOrganizer taskOrganizer;

	public JobRestController(final TaskOrganizer organizadorDeJobs) {
		this.taskOrganizer = organizadorDeJobs;
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<List<Job>> postJobs(@RequestBody @Valid List<Job> jobs) {
		return taskOrganizer.generateNextExecutionLists(jobs);
	}

}
