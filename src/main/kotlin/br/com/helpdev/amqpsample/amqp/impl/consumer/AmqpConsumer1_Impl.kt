package br.com.helpdev.amqpsample.amqp.impl.consumer

import br.com.helpdev.amqpsample.amqp.AmqpConfiguration
import br.com.helpdev.amqpsample.amqp.AmqpConsumer
import br.com.helpdev.amqpsample.amqp.AmqpProcessor
import br.com.helpdev.amqpsample.amqp.ExchangeConsumer
import com.rabbitmq.client.Channel
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class AmqpConsumer1_Impl(
        private val processors: Map<ExchangeConsumer, AmqpProcessor>
) : AmqpConsumer {


    @RabbitListener(queues = [AmqpConfiguration.SERVER_CONSUMER_QUEUE])
    override fun receiveMessage(message: Message, channel: Channel) {
        if (process(message)) {
            channel.basicAck(message.messageProperties.deliveryTag, false)
        }
    }


    fun process(message: Message): Boolean {
        val amqpProcessor = processors[ExchangeConsumer.byName(message.messageProperties.receivedExchange)]
        amqpProcessor?.processor(message.body)
        return true
    }

}