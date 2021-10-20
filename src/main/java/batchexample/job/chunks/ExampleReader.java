package batchexample.job.chunks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ExampleReader implements ItemReader<String> {
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        log.info("Example reader was called");
        List<String> example = new ArrayList<>();
        example.add("Hello ");
        example.add("World!");
        if(example.isEmpty()) {
            return null;
        }
        return example.remove(0);
    }
}
