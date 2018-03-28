package com.bytesville.monitoring.bookstore.metrics

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
class MetricsConfiguration(private var registry: MeterRegistry) {

  fun MetricsConfiguration(registry:MeterRegistry) {
    this.registry = registry
  }
  @Bean fun cvmMemoryMetrics():ClassLoaderMetrics {
    return ClassLoaderMetrics()
  }

  var timer: Timer = Timer.builder("my")
      .description("custom timer")
      .tags("custom", "function")
      .register(registry)

  var temp  = timer.record(
      {
        TimeUnit.MILLISECONDS.sleep(1500)
      }
  )
}