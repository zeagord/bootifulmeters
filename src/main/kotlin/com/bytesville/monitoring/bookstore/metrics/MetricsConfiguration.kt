package com.bytesville.monitoring.bookstore.metrics

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
class MetricsConfiguration {

  @Bean fun cvmMemoryMetrics(): ClassLoaderMetrics {
    return ClassLoaderMetrics()
  }
}