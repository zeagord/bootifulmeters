package com.bytesville.monitoring.bookstore.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Book (
  @Id
  var id: String ? = null,

  var title: String,

  var author: String
)