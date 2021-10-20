package batchexample.controller;

import batchexample.model.ExampleRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ExampleJobController {

    private final JobLauncher jobLauncher;
    private final Job exampleJob;

    @SneakyThrows
    @PostMapping("/job")
    public ResponseEntity<String> job(@RequestBody ExampleRequestDto requestDto) {

        JobExecution run = jobLauncher.run(exampleJob, dtoToJobParameters(requestDto));
        return new ResponseEntity<>("Job was executed with exitCode " + run.getExitStatus().getExitCode(), HttpStatus.OK);
    }

    private JobParameters dtoToJobParameters(ExampleRequestDto requestDto) {
        Map<String, JobParameter> parameters = new HashMap<>();
        for (Map.Entry<String, String> entry : requestDto.getStringStringMap().entrySet()) {
            JobParameter jobParameter = new JobParameter(entry.getValue());
            parameters.put(entry.getKey(), jobParameter);
        }
        parameters.put("time", new JobParameter(LocalDateTime.now().toString()));
        return new JobParameters(parameters);
    }
}
