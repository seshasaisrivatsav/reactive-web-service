package com.example.springflux.reactivewebservice.handler;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MyWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        // Handle the WebSocket session

        // Receive messages from the client
        Flux<WebSocketMessage> messageFlux = session.receive()
                .doOnNext(message -> {
                    // Process the received message
                    String payload = message.getPayloadAsText();
                    System.out.println("Received: " + payload);

                    // Send a response back to the client
                    session.send(Mono.just(session.textMessage("Received: " + payload)))
                            .subscribe();
                });

        // Send a welcome message to the client upon connection
        session.send(Mono.just(session.textMessage("Connected!")))
                .subscribe();

        // Return the message flux to keep the connection open
        return session.send(messageFlux);
    }
}
