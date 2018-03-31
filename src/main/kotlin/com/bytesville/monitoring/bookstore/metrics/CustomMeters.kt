package com.bytesville.monitoring.bookstore.metrics

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit

@Component
class CustomMeters(private val registry: MeterRegistry) {

  val log: Logger = LoggerFactory.getLogger(CustomMeters::class.java)

  val timer = Timer.builder("my")
      .description("custom function timer")
      .tags("custom", "timer")
      .register(registry)

  val temp = timer.record(
      {
        log.info("Time to do some costly operation and sleep")
        TimeUnit.MILLISECONDS.sleep(1500)
      }
  )
}