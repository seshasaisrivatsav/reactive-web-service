package com.example.springflux.reactivewebservice.router;
import com.example.springflux.reactivewebservice.handler.TestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TestRouter {

    @Bean
    public RouterFunction<ServerResponse> itemRoute(TestHandler handler) {
        return route(GET("/item"), handler::getItem);
    }
}