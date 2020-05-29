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
import com.br.gabriel.jobManager.service.OrganizadorDeJobs;


@RunWith(SpringRunner.class)
class TestaOrganizadorDeJobs {
	
	OrganizadorDeJobs organizadorDeJobs;
	List<Job> listaPriorizada;
	List<Job> listaDeJobs1;
	List<Job> listaDeJobs2;
	Job job1 ;
	Job job2 ;
	Job job3 ;
	Job job4 ;
	Job job5 ;
	Job job6 ;
	 
	
	@BeforeEach
	public void init() {
		
		organizadorDeJobs = new OrganizadorDeJobs();
		listaPriorizada = new ArrayList<Job>();
		criarJobs();
		listaDeJobs1 = new ArrayList<Job>();
		listaDeJobs2 = new ArrayList<Job>();
		
		listaDeJobs1.add(job1);
		listaDeJobs1.add(job2);
		listaDeJobs1.add(job3);
		
		listaDeJobs2.add(job4);
		listaDeJobs2.add(job5);
		listaDeJobs2.add(job6);

	}


	
	@Test
	public void criarListaPriorizada(){
		List<Job> listaDeTeste = List.of(job1,job3);
		 
		listaPriorizada = organizadorDeJobs.criarListaPriorizada(listaDeJobs1);
		 
		MatcherAssert.assertThat(listaPriorizada, CoreMatchers.is(listaDeTeste));
	}
	
	@Test
	public void adicionarJobsPriorizadosNaFilaDeExecucao(){
		List<List<Job>> filaDeExecucao = new ArrayList<List<Job>>();
		
		listaPriorizada = organizadorDeJobs.criarListaPriorizada(listaDeJobs1);
		
		organizadorDeJobs.adicionarJobsPriorizadosNaFilaDeExecucao(listaPriorizada, filaDeExecucao);
		
		listaPriorizada = organizadorDeJobs.criarListaPriorizada(listaDeJobs2);

		organizadorDeJobs.adicionarJobsPriorizadosNaFilaDeExecucao(listaPriorizada, filaDeExecucao);
		
	
		List<Job> listaDeTeste1 = List.of(job1,job3);
		
		List<Job> listaDeTeste2 = List.of(job4,job5);
		
		List<List<Job>> listaTesteFinal = new ArrayList<List<Job>>();
		
		listaTesteFinal.add(listaDeTeste1);
		listaTesteFinal.add(listaDeTeste2);
		
		MatcherAssert.assertThat(filaDeExecucao, CoreMatchers.is(listaTesteFinal));
		 
	}
	
	
	private void criarJobs() {
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
