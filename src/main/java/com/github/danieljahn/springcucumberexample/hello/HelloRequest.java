package com.github.danieljahn.springcucumberexample.hello;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class HelloRequest {
    String name;
}
