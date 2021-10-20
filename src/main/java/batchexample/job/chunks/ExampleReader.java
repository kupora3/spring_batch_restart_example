package batchexample.job.chunks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class ExampleReader implements ItemReader<String> {
    private List<String> example = new ArrayList<>(List.of("Hello", "World"));

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        log.info("Example reader was called");
        if(example.isEmpty()) {
            return null;
        }
        return example.remove(0);
    }
}
