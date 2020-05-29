package com.br.gabriel.jobManager;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.br.gabriel.jobManager.controller.JobRestController;
import com.br.gabriel.jobManager.service.TaskOrganizer;

@RunWith(SpringRunner.class)
@WebMvcTest(JobRestController.class)
public class JobRestControllerIntegrationTest {

	@TestConfiguration
	static class TaskOrganizerTestContextConfiguration {

		@Bean
		public TaskOrganizer taskOrganizer() {
			return new TaskOrganizer();
		}
	}

	@Autowired
	private MockMvc mvc;

	@Test
	public void RequestTocreateNewJobList() throws Exception {

		String requestJson = "[\n" 
				+ "    {\n" 
				+ "        \"id\": 1,\n" 
				+ "        \"descricao\": \"descricao\",\n"
				+ "        \"dataMaximaDeConclusao\": \"2020-05-27T22:28:18.927642\",\n"
				+ "        \"tempoEstimado\": 4\n" 
				+ "    },\n" 
				+ "    {\n"
				+ "        \"id\": 2,\n"
				+ "        \"descricao\": \"descricao2\",\n"
				+ "        \"dataMaximaDeConclusao\": \"2020-05-29T19:28:18.927725\",\n"
				+ "        \"tempoEstimado\": 6\n" 
				+ "    },\n"
				+ "    {\n"
				+ "        \"id\": 3,\n"
				+ "        \"descricao\": \"descricao3\",\n"
				+ "        \"dataMaximaDeConclusao\": \"2020-05-28T19:28:18.927725\",\n"
				+ "        \"tempoEstimado\": 2\n"
				+ "    }\n"
				+ "]";
		
			String responseJson = "[\n" + 
					"    [\n" + 
					"        {\n" + 
					"            \"id\": 1,\n" + 
					"            \"descricao\": \"descricao\",\n" + 
					"            \"dataMaximaDeConclusao\": \"2020-05-27T22:28:18.927642\",\n" + 
					"            \"tempoEstimado\": 4\n" + 
					"        },\n" + 
					"        {\n" + 
					"            \"id\": 3,\n" + 
					"            \"descricao\": \"descricao3\",\n" + 
					"            \"dataMaximaDeConclusao\": \"2020-05-28T19:28:18.927725\",\n" + 
					"            \"tempoEstimado\": 2\n" + 
					"        }\n" + 
					"    ],\n" + 
					"    [\n" + 
					"        {\n" + 
					"            \"id\": 2,\n" + 
					"            \"descricao\": \"descricao2\",\n" + 
					"            \"dataMaximaDeConclusao\": \"2020-05-29T19:28:18.927725\",\n" + 
					"            \"tempoEstimado\": 6\n" + 
					"        }\n" + 
					"    ]\n" + 
					"]";

		mvc.perform(post("/job/")
				.content(requestJson)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(responseJson));

	}

}
