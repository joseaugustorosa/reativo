package com.jose.reativo;

import com.jose.reativo.service.ExternoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import org.testcontainers.containers.MockServerContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
public class ExternoServiceTest {

    @Container
    public static MockServerContainer mockServer = new MockServerContainer();

    private static ExternoService externoService;

    @BeforeAll
    public static void setUp() {
        String baseUrl = "http://" + mockServer.getHost() + ":" + mockServer.getServerPort();
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();
        externoService = new ExternoService((WebClient.Builder) webClient);

    }

    @Test
    public void testFetchData() {
        Mono<String> response = externoService.fetchData();


        String result = response.block();
        assertThat(result).contains("Test simple.");
    }
}
