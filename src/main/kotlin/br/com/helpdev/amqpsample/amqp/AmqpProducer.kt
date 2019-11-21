package br.com.helpdev.amqpsample.amqp

import org.springframework.amqp.rabbit.core.RabbitTemplate

abstract class AmqpProducer(
        private val rabbitTemplate: RabbitTemplate,
        val exchange: ExchangeProducer
) {

    fun send(message: String, routingKey: String = "") {
        rabbitTemplate.convertAndSend(exchange.value, routingKey, process(message))
    }

    open fun process(message: String): String {
        return message
    }
}