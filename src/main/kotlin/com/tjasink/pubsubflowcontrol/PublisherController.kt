package com.tjasink.pubsubflowcontrol

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping

@Controller
class PublisherController(
    private val publisher: Publisher
) {

    @PostMapping("/publish")
    fun publish(): ResponseEntity<String> {
        publisher.publishMessages(20)
        return ResponseEntity.ok("Ok")
    }

}
