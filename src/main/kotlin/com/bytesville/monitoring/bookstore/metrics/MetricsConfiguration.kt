package com.bytesville.monitoring.bookstore.metrics

import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MetricsConfiguration {
  @Bean fun cvmMemoryMetrics() = ClassLoaderMetrics()
}