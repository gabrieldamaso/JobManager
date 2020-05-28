package com.br.gabriel.jobManager.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


@Data
@Builder
public class Job {

	
	private long id;
	@NonNull
	private String descricao;
	@NonNull
	private LocalDateTime dataMaximaDeConclusao;
	private int tempoEstimado;
	

	
}
