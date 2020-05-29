package com.br.gabriel.jobManager.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;


@Builder
@AllArgsConstructor
@Getter
public class Job {

	
	private long id;
	@NonNull
	private String descricao;
	@NonNull
	private LocalDateTime dataMaximaDeConclusao;
	private int tempoEstimado;
	

	
}
