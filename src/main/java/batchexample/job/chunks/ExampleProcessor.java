package batchexample.job.chunks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExampleProcessor implements ItemProcessor<String,String> {
    @Override
    public String process(String item) throws Exception {
        log.info("Example Processor was called");
        return item;
    }
}
