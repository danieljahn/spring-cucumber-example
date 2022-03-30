package com.github.danieljahn.springcucumberexample.bdd.hello;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Map;

@Component
public class HelloClient {

    @Autowired
    WebTestClient client;

    private WebTestClient.ResponseSpec responseSpec;

    @SneakyThrows
    public void requestGreeting(String name) {
        final var requestBody = Map.of("name", name);

        responseSpec = client
                .post().uri("/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .exchange();
    }

    public void assertGreeting(String expectedMessage) {
        responseSpec.expectBody()
                .jsonPath("message", expectedMessage).isEqualTo(expectedMessage);
    }

    public void assertRepsonseCode(int responseCode) {
        responseSpec.expectStatus().isEqualTo(responseCode);
    }

    public void assertBodyField(String fieldName, String expectedValue) {
        responseSpec.expectBody()
                .jsonPath(fieldName).isEqualTo(expectedValue);
    }
}
