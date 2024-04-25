package com.tjasink.pubsubflowcontrol

import com.google.cloud.spring.pubsub.core.PubSubTemplate
import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage
import com.google.protobuf.ByteString
import com.google.pubsub.v1.PubsubMessage
import org.springframework.stereotype.Component
import java.nio.charset.Charset

@Component
class Publisher(
    pubSubTemplate: PubSubTemplate
) {
    private val publisher = pubSubTemplate.publisherFactory.createPublisher("test-topic")

    fun publishMessages(num: Int) {
        for (i in 1 until num) {
            println("Publishing message $i")
            val message = PubsubMessage.newBuilder().setData(ByteString.copyFrom("$i", Charset.defaultCharset())).build()
            publisher.publish(message)
        }
    }
}
