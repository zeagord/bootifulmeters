package com.bytesville.monitoring.bookstore.repository

import com.bytesville.monitoring.bookstore.model.Book
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository:ReactiveMongoRepository<Book, String> {}