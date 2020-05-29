package com.br.gabriel.jobManager.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.gabriel.jobManager.model.Job;

@Service
public class TaskOrganizer {
	
	public List<List<Job>> generateNextExecutionLists(List<Job> jobsList) {
		List<List<Job>> executionList = new ArrayList<List<Job>>();
		boolean firstTime = true;
		List<Job> prioritizedList = new ArrayList<Job>();
		
		while(firstTime || !searchforNonPrioritizedJobs(prioritizedList,jobsList).isEmpty()) {
			prioritizedList = createPriorizedList(searchforNonPrioritizedJobs(prioritizedList,jobsList));
			addPriorityJobsInExecutionList(prioritizedList,executionList);
			firstTime = false;
		}
		
		return executionList;
	}
		
	private List<Job> searchforNonPrioritizedJobs(List<Job> prioritizedList, List<Job> jobsList) {
		jobsList.removeAll(prioritizedList);
		return jobsList; 
	}

	public List<Job> createPriorizedList(List<Job> jobsList){
		List<Job> prioritizedList = new ArrayList<Job>();
		jobsList.sort(Comparator.comparing(Job::getDataMaximaDeConclusao));
		
		int timeSum = 0;
		
		for (Job job : jobsList) {
			if(timeSum + job.getTempoEstimado() <= 8) {
				prioritizedList.add(job);
				timeSum += job.getTempoEstimado();
			}
		}
		
		return prioritizedList;
	}

		
	public void addPriorityJobsInExecutionList(List<Job> listaDeJobsPriorizada, List<List<Job>> filaDeExecucao) {
		filaDeExecucao.add(listaDeJobsPriorizada);
	}
	
	
}
