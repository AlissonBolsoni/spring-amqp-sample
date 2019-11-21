package br.com.helpdev.amqpsample.amqp

import com.rabbitmq.client.Channel
import org.springframework.amqp.core.Message

interface AmqpConsumer {
    fun receiveMessage(message: Message, channel: Channel)
}
