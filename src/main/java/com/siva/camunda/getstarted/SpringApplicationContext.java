package com.siva.camunda.getstarted;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.ProcessEngineService;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.spring.application.SpringProcessApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringApplicationContext extends SpringBootServletInitializer {
	private static final Logger LOG = LoggerFactory.getLogger(SpringApplicationContext.class);
	public static void main(String[] args) {
		LOG.info("Running SpringApplicationContext");
		SpringApplication.run(SpringApplicationContext.class, args);
	}

	@Bean
	public ProcessEngineService processEngineService() {
		return BpmPlatform.getProcessEngineService();
	}

	@Bean(destroyMethod = "")
	public ProcessEngine processEngine() {
		return BpmPlatform.getDefaultProcessEngine();
	}

	@Bean
	public SpringProcessApplication processApplication() {
		LOG.info("Running processApplication");
		return new SpringProcessApplication();
	}

	@Bean
	public RepositoryService repositoryService(ProcessEngine processEngine) {
		return processEngine.getRepositoryService();
	}

	@Bean
	public RuntimeService runtimeService(ProcessEngine processEngine) {
		return processEngine.getRuntimeService();
	}

	@Bean
	public TaskService taskService(ProcessEngine processEngine) {
		return processEngine.getTaskService();
	}

	@Bean
	public HistoryService historyService(ProcessEngine processEngine) {
		return processEngine.getHistoryService();
	}

	@Bean
	public ManagementService managementService(ProcessEngine processEngine) {
		return processEngine.getManagementService();
	}
}
