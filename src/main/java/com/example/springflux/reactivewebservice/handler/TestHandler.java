package com.example.springflux.reactivewebservice.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class TestHandler {

    public Mono<ServerResponse> getItem(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just("Item 1"), String.class);
    }

    public Mono<ServerResponse> websocketTest(ServerRequest request) {
        Flux<String> messageFlux = Flux.just("first", "second")
                .delayElements(Duration.ofSeconds(3));

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromPublisher(messageFlux, String.class));
    }
}
