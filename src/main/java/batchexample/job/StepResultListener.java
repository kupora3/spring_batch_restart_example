package batchexample.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
@Slf4j
public class StepResultListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("beforeStep was called with stepName:{}", stepExecution.getStepName());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("afterStep was called with stepName:{} and exitStatus:{}", stepExecution.getStepName(), stepExecution.getExitStatus());
        return null;
    }
}