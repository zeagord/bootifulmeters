package com.bytesville.monitoring.bookstore.route

import com.bytesville.monitoring.bookstore.handler.BookHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Flux

@Configuration
class StoreRoute(private val bookHandler: BookHandler) {

  @Bean
  fun client() = WebClient.builder().build();

  @Bean
  fun routes(client: WebClient) = router {
    GET("/hello", { ServerResponse.ok().body(Flux.just("Hello reactive"), String::class.java) })
    GET("/ip", {
      val ip: Flux<String> = client
          .get()
          .uri("http://httpbin.org/ip")
          .retrieve()
          .bodyToFlux(String::class.java)
      ServerResponse.ok().body(ip, String::class.java)
    })
    POST("/book", {bookHandler.saveBooks(it)})
    GET("/book", {bookHandler.listBooks(it)})
  }
}