package batchexample.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

@Slf4j
public class JobResultListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("beforeJob was called");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("Job was completed with exitCode:{}", jobExecution.getExitStatus().getExitCode());
    }
}
