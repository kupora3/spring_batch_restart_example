package batchexample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExampleRequestDto {
    @JsonProperty("jobName")
    private String jobName;

    @JsonProperty("params")
    private Map<String, String> stringStringMap = new HashMap<>();
}
