package com.github.danieljahn.springcucumberexample.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class HelloIT {

    @Autowired
    WebTestClient client;

    @Test
    void shouldGreet() {
        final var body = Map.of("name", "John");

        client
                .post()
                .uri("/hello")
                .bodyValue(body)
                .exchange()
                .expectStatus().isEqualTo(200)
                .expectBody()
                    .jsonPath("$.message").isEqualTo("Hello, John!");
    }
}
