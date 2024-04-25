package com.tjasink.pubsubflowcontrol

import com.google.cloud.spring.pubsub.core.PubSubTemplate
import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage
import org.springframework.stereotype.Component
import java.nio.charset.Charset
import java.util.concurrent.atomic.AtomicInteger

@Component
class Subscriber(
    pubSubTemplate: PubSubTemplate
) {
    init {
        pubSubTemplate.subscribe("test-subscription", ::processMessage)
    }

    val total = AtomicInteger(0)

    fun processMessage(message: BasicAcknowledgeablePubsubMessage) {
        val content = message.pubsubMessage.data.toString(Charset.defaultCharset())
        val ourTotal = total.incrementAndGet()
        println("Got message $content (total $ourTotal)")
        Thread.sleep(5_000)
        message.ack()
    }
}
