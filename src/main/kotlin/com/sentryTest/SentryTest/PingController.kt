package com.sentryTest.SentryTest

import io.sentry.Sentry
import io.sentry.event.BreadcrumbBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController {
    @GetMapping("/ping")
    fun ping(): String {
        Sentry.getContext().recordBreadcrumb(
            BreadcrumbBuilder()
                .withData("key", "some awesome value")
                .setMessage("some really cool log")
                .build()
        )
        Sentry.capture("this is a test event")
        return "pong"
    }
}