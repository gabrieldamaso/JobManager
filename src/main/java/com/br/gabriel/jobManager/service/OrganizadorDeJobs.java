package com.br.gabriel.jobManager.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.gabriel.jobManager.model.Job;

@Service
public class OrganizadorDeJobs {
	
	List<List<Job>> filaDeExecucao = new ArrayList<List<Job>>();
	List<Job> listaNaoPriorizada = new ArrayList<Job>();
	
	public void gerarProximasListasDeExecucao(List<Job> listaDeJobs) {
		
		List<Job> listaPriorizada = criarListaPriorizada(listaDeJobs);
		adicionarJobsPriorizadosNaFilaDeExecucao(listaPriorizada);
		
		while(!listaNaoPriorizada.isEmpty()) {
			gerarProximasListasDeExecucao(listaNaoPriorizada);
		}
		
		executarFilaDeJobs();
	}
		
	public List<Job> criarListaPriorizada(List<Job> listaDeJobs){
		List<Job> listaPriorizada = new ArrayList<Job>();
		listaDeJobs.sort(Comparator.comparing(Job::getDataMaximaDeConclusao));
		
		int somaDeTempo = 0;
		
		for (Job job : listaDeJobs) {
			if(somaDeTempo + job.getTempoEstimado() <= 8) {
				listaPriorizada.add(job);
				somaDeTempo += job.getTempoEstimado();
			}
		}
		
		return listaPriorizada;
	}

		
	public void adicionarJobsPriorizadosNaFilaDeExecucao(List<Job> listaDeJobsPriorizada) {
		filaDeExecucao.add(listaDeJobsPriorizada);
	}
	
	public List<List<Job>> buscarFilaDeExecucao(){
		return Collections.unmodifiableList(filaDeExecucao) ;
	} 
	
	private void executarFilaDeJobs() {
		for (List<Job> list : filaDeExecucao) {
			
		}
	}
}
