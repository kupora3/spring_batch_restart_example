package batchexample.job.chunks;

import batchexample.job.StepResultListener;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ExampleChunkStepConfig {
    private final StepBuilderFactory stepBuilder;
    private final ItemReader<String> exampleReader;
    private final ItemProcessor<String,String> exampleProcessor;
    private final ItemWriter<String> exampleWriter;

    @Bean
    public Step exampleChunkStep() {
        return stepBuilder.get("exampleChunkStep")
                .listener(new StepResultListener())
                .<String, String>chunk(10)
                .reader(exampleReader)
                .processor(exampleProcessor)
                .writer(exampleWriter)
                .faultTolerant()
                .retryLimit(3)
                .retry(Exception.class)
                .build();
    }
}
