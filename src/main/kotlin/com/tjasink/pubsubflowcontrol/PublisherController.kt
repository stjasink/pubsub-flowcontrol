package com.tjasink.pubsubflowcontrol

import com.google.cloud.spring.pubsub.core.PubSubTemplate
import com.google.protobuf.ByteString
import com.google.pubsub.v1.PubsubMessage
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import java.nio.charset.Charset

@Controller
class PublisherController(
    private val pubSubTemplate: PubSubTemplate
) {

    private val publisher = pubSubTemplate.publisherFactory.createPublisher("test-topic")

    @PostMapping("/publish")
    fun publish(): ResponseEntity<String> {
        for (i in 1 .. 20) {
            println("Publishing message $i")
            val message = PubsubMessage.newBuilder().setData(ByteString.copyFrom("$i", Charset.defaultCharset())).build()
            publisher.publish(message)
        }
        return ResponseEntity.ok("Ok\n")
    }

}
