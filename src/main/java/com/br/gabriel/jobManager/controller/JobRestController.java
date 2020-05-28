package com.br.gabriel.jobManager.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.gabriel.jobManager.model.Job;
import com.br.gabriel.jobManager.service.OrganizadorDeJobs;

@RestController
@RequestMapping("job")
public class JobRestController {
	
	@Autowired
	OrganizadorDeJobs organizadorDeJobs;

	@RequestMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	@GetMapping(value = "/teste", produces = "application/json")
    public Job getJob() {
		List<Job> listaDeJobs = new ArrayList<Job>();
		
		 listaDeJobs.add(Job.builder().id(1).tempoEstimado(2).descricao("descricao").dataMaximaDeConclusao(LocalDateTime.now().minusDays(1)).build());
		 listaDeJobs.add(Job.builder().id(2).tempoEstimado(4).descricao("descricao2").dataMaximaDeConclusao(LocalDateTime.now().plusHours(4)).build());
		 listaDeJobs.add(Job.builder().id(3).tempoEstimado(6).descricao("descricao3").dataMaximaDeConclusao(LocalDateTime.now().minusHours(3)).build());
		 
		 organizadorDeJobs.criarListaPriorizada(listaDeJobs);
		
        return null;
    }

}
