package com.br.gabriel.jobManager.model;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

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
	@Min(value = 1, message = "o tempo nao pode ser menor do que 1h")
    @Max(value = 8, message = "o tempo nao pode ser maior do que 8h")
	@Positive
	private int tempoEstimado;
	

	
}
