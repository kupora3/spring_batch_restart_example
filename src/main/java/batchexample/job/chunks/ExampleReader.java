package batchexample.job.chunks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ExampleReader implements ItemReader<String> {
    private List<String> example = new ArrayList<>(List.of("Hello", "World"));

    @Override
    public String read() {
        log.info("Example reader was called");
        if(example.isEmpty()) {
            return null;
        }
        return example.remove(0);
    }
}
