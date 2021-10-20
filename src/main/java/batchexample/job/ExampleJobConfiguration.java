package batchexample.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ExampleJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final Step exampleTasklet1Step;
    private final Step exampleTasklet2Step;
    private final Step exampleChunkStep;

    @Bean
    public Job exampleJob() {
        return jobBuilderFactory.get("exampleJob")
                .listener(new JobResultListener())
                .start(exampleTasklet1Step)
                .next(exampleTasklet2Step)
                .next(exampleChunkStep)
                .build();
    }
}
