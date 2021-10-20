package batchexample.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ExampleTaskletStepConfig {
    private final StepBuilderFactory stepBuilder;
    private final Tasklet exampleTasklet1;
    private final Tasklet exampleTasklet2;

    @Bean
    public Step exampleTasklet1Step() {
        return stepBuilder.get("exampleTasklet1")
                .listener(new StepResultListener())
                .tasklet(exampleTasklet1)
                .build();
    }

    @Bean
    public Step exampleTasklet2Step() {
        return stepBuilder.get("exampleTasklet2")
                .listener(new StepResultListener())
                .tasklet(exampleTasklet2)
                .build();
    }
}
