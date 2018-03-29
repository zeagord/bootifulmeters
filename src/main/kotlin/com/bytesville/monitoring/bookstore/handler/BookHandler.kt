package com.bytesville.monitoring.bookstore.handler

import com.bytesville.monitoring.bookstore.model.Book
import com.bytesville.monitoring.bookstore.repository.BookRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class BookHandler(private val repository:BookRepository) {
  fun saveBooks(request: ServerRequest): Mono<ServerResponse>{
    val book: Flux<Book> =request.bodyToFlux(Book::class.java)
    return ServerResponse.ok().body(repository.insert(book), Book::class.java)
  }

  fun listBooks(request: ServerRequest): Mono<ServerResponse> {
    return ServerResponse
        .ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(repository.findAll(), Book::class.java)
  }
}