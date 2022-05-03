package com.github.danieljahn.springcucumberexample.hello;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.text.MessageFormat;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @PostMapping
    Mono<HelloResponse> sayHello(@RequestBody HelloRequest requestBody) {
        final var message = MessageFormat.format("Hello, {0}!", requestBody.name);
        final var helloResponse = HelloResponse.builder().message(message).build();
        return Mono.just(helloResponse);
    }
}
