package com.bytesville.monitoring.bookstore.metrics

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics

@Configuration
class MetricsConfiguration {

  @Bean fun cvmMemoryMetrics():ClassLoaderMetrics {
    return ClassLoaderMetrics()
  }
}