package br.com.helpdev.amqpsample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AmqpSampleApplication

fun main(args: Array<String>) {
    runApplication<AmqpSampleApplication>(*args)
}
