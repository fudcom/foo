package com.dynatrace.vast.playground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VastPlaygroundApplication

fun main(args: Array<String>) {
	runApplication<VastPlaygroundApplication>(*args)
}
