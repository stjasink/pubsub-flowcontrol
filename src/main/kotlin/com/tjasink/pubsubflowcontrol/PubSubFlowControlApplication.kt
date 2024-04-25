package com.tjasink.pubsubflowcontrol

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

fun main(args: Array<String>) {
	runApplication<PubSubFlowControlApplication>(*args)
}

@SpringBootApplication
class PubSubFlowControlApplication : SpringBootServletInitializer()
