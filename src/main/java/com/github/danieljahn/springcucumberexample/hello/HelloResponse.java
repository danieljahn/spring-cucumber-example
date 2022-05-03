package com.github.danieljahn.springcucumberexample.hello;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class HelloResponse {
    String message;
}
