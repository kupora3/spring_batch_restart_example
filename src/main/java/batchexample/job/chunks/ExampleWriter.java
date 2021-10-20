package batchexample.job.chunks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@Slf4j
@Component
public class ExampleWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> items) throws Exception {
        log.info("Example writer was called");
//        String read = new String(Files.readAllBytes(Paths.get("src/main/resources/product_invalid2.json")));
//        log.info(read);
    }
}
