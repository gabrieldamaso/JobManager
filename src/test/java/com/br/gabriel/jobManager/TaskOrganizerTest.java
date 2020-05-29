package com.br.gabriel.jobManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.gabriel.jobManager.model.Job;
import com.br.gabriel.jobManager.service.TaskOrganizer;


@RunWith(SpringRunner.class)
class TaskOrganizerTest {
	
	TaskOrganizer jobsOrganizer;
	List<Job> prioritizedList;
	List<Job> jobsList1;
	List<Job> jobsList2;
	Job job1 ;
	Job job2 ;
	Job job3 ;
	Job job4 ;
	Job job5 ;
	Job job6 ;
	 
	
	@BeforeEach
	public void init() {
		
		jobsOrganizer = new TaskOrganizer();
		prioritizedList = new ArrayList<Job>();
		createJobs();
		jobsList1 = new ArrayList<Job>();
		jobsList2 = new ArrayList<Job>();
		
		jobsList1.add(job1);
		jobsList1.add(job2);
		jobsList1.add(job3);
		
		jobsList2.add(job4);
		jobsList2.add(job5);
		jobsList2.add(job6);

	}
	
	@Test
	public void createPriorizedList(){
		List<Job> testList = List.of(job1,job3);
		 
		prioritizedList = jobsOrganizer.createPriorizedList(jobsList1);
		 
		MatcherAssert.assertThat(prioritizedList, CoreMatchers.is(testList));
	}
	
	@Test
	public void addPriorityJobsInExecutionList(){
		List<List<Job>> executionList = new ArrayList<List<Job>>();
		
		prioritizedList = jobsOrganizer.createPriorizedList(jobsList1);
		
		jobsOrganizer.addPriorityJobsInExecutionList(prioritizedList, executionList);
		
		prioritizedList = jobsOrganizer.createPriorizedList(jobsList2);

		jobsOrganizer.addPriorityJobsInExecutionList(prioritizedList, executionList);
		
	
		List<Job> testList1 = List.of(job1,job3);
		
		List<Job> testList2 = List.of(job4,job5);
		
		List<List<Job>> finalTestList = new ArrayList<List<Job>>();
		
		finalTestList.add(testList1);
		finalTestList.add(testList2);
		
		MatcherAssert.assertThat(executionList, CoreMatchers.is(finalTestList));
		 
	}
	
	
	private void createJobs() {
		job1 = Job.builder()
				.id(1)
				.tempoEstimado(2)
				.descricao("descricao")
				.dataMaximaDeConclusao(LocalDateTime
						.now()
						.minusDays(1))
				.build();
		job2 = Job.builder()
				.id(2)
				.tempoEstimado(4)
				.descricao("descricao2")
				.dataMaximaDeConclusao(LocalDateTime
						.now()
						.plusHours(4))
				.build();
		job3 = Job.builder()
				.id(3)
				.tempoEstimado(6)
				.descricao("descricao3")
				.dataMaximaDeConclusao(LocalDateTime
						.now()
						.minusHours(3))
				.build();
		
		job4 = Job.builder()
				.id(4)
				.tempoEstimado(2)
				.descricao("descricao4")
				.dataMaximaDeConclusao(LocalDateTime
						.now()
						.minusDays(1))
				.build();
		
		job5 = Job.builder()
				.id(5)
				.tempoEstimado(2)
				.descricao("descricao5")
				.dataMaximaDeConclusao(LocalDateTime
						.now()
						.minusHours(4))
				.build();
		
		job6 = Job.builder()
				.id(6)
				.tempoEstimado(7)
				.descricao("descricao6")
				.dataMaximaDeConclusao(LocalDateTime
						.now()
						.plusHours(3))
				.build();
	}

}
