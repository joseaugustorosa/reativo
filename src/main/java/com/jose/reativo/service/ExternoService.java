package com.jose.reativo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ExternoService {

    private final WebClient webClient;

    public ExternoService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.adviceslip.com/advice").build();
    }

    public Mono<String> fetchData() {
        return this.webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> "Resposta: " + response);
    }
}
