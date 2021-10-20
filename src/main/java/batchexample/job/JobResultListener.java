package batchexample.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class JobResultListener implements JobExecutionListener {
//    @Autowired
//    private JobLauncher jobLauncher;
//    @Autowired
//    private JobRepository jobRepository;
//    @Autowired
//    private JobExplorer jobExplorer;
//    @Autowired
//    private JobRegistry jobRegistry;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("beforeJob was called");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
//        SimpleJobOperator jobOperator = new SimpleJobOperator();
//        jobOperator.setJobExplorer(jobExplorer);
//        jobOperator.setJobLauncher(jobLauncher);
//        jobOperator.setJobRegistry(jobRegistry);
//        jobOperator.setJobRepository(jobRepository);
//
//        Long executionId = jobExecution.getJobId();
//        if (jobExecution.getStatus().equals(BatchStatus.FAILED)) {
//            try {
//                jobOperator.restart(executionId);
//            } catch (Exception e) {
//                log.error("Error resuming job " + executionId + ", a new job instance will be created. Cause: " + e.getLocalizedMessage());
//            }
//        }
        log.info("Job was completed with exitCode:{}", jobExecution.getExitStatus().getExitCode());
    }
}
