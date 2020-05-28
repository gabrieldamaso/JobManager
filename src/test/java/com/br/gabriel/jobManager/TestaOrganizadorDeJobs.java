package com.br.gabriel.jobManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.gabriel.jobManager.model.Job;
import com.br.gabriel.jobManager.service.OrganizadorDeJobs;


@RunWith(SpringRunner.class)
class TestaOrganizadorDeJobs {

	@Test
	public void testaCriarListaPriorizada(){
		
		 List<Job> listaDeJobs = new ArrayList<Job>();
		 
		 Job job1 = Job.builder().id(1).tempoEstimado(2).descricao("descricao").dataMaximaDeConclusao(LocalDateTime.now().minusDays(1)).build();
		 Job job2 = Job.builder().id(2).tempoEstimado(4).descricao("descricao2").dataMaximaDeConclusao(LocalDateTime.now().plusHours(4)).build();
		 Job job3 = Job.builder().id(3).tempoEstimado(6).descricao("descricao3").dataMaximaDeConclusao(LocalDateTime.now().minusHours(3)).build();
		 
		 listaDeJobs.add(job1);
		 listaDeJobs.add(job2);
		 listaDeJobs.add(job3);
		 
		 List<Job> listaDeTeste = List.of(job1,job3);
		 
		 OrganizadorDeJobs organizadorDeJobs = new OrganizadorDeJobs();
		 
		 List<Job> criarListaPriorizada = organizadorDeJobs.criarListaPriorizada(listaDeJobs);
		 
		 
		 MatcherAssert.assertThat(criarListaPriorizada, CoreMatchers.is(listaDeTeste));
	}

}
