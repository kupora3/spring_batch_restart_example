package batchexample.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExampleJobController {

    private final JobLauncher jobLauncher;
    private final Job exampleJob;

    @SneakyThrows
    @GetMapping("/job")
    public ResponseEntity<String> job() {
        jobLauncher.run(exampleJob, new JobParameters());
        return new ResponseEntity<>("Wrong job name", HttpStatus.OK);
    }
}
