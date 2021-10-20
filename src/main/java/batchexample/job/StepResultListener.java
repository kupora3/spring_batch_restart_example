package batchexample.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class StepResultListener implements StepExecutionListener {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobExplorer jobExplorer;
    @Autowired
    private JobRegistry jobRegistry;

    public StepResultListener() {
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("beforeStep was called with stepName:{}", stepExecution.getStepName());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        SimpleJobOperator jobOperator = new SimpleJobOperator();
        jobOperator.setJobExplorer(jobExplorer);
        jobOperator.setJobLauncher(jobLauncher);
        jobOperator.setJobRegistry(jobRegistry);
        jobOperator.setJobRepository(jobRepository);
        Long executionId = stepExecution.getJobExecution().getJobId();
        if (stepExecution.getStatus().equals(BatchStatus.FAILED)) {
            try {
                jobOperator.restart(executionId);
            } catch (Exception e) {
                log.error("Error resuming job " + executionId + ", a new job instance will be created. Cause: " + e.getLocalizedMessage());
            }
        }
        log.info("afterStep was called with stepName:{} and exitStatus:{}", stepExecution.getStepName(), stepExecution.getExitStatus());
        return ExitStatus.COMPLETED;
    }
}
