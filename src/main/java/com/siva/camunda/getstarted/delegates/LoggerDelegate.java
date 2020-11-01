package com.siva.camunda.getstarted.delegates;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("logger")
public class LoggerDelegate implements JavaDelegate {
	private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("\n\n  ... LoggerDelegate invoked by " + "processDefinitionId=" + execution.getProcessDefinitionId()
				+ ", activtyId=" + execution.getCurrentActivityId() + ", activtyName='"
				+ execution.getCurrentActivityName() + "'" + ", processInstanceId=" + execution.getProcessInstanceId()
				+ ", businessKey=" + execution.getProcessBusinessKey() + ", executionId=" + execution.getId()
				+ " \n\n");
	}

}
