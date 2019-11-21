package br.com.helpdev.amqpsample.amqp

import org.springframework.amqp.core.*
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.ArrayList


@Configuration
class AmqpConfiguration {

    companion object {
        const val SERVER_CONSUMER_QUEUE = "server.test"
    }


    @Bean(SERVER_CONSUMER_QUEUE)
    fun queue(): Queue {
        return Queue(SERVER_CONSUMER_QUEUE, true, false, false, null)
    }

    @Bean
    fun loadConsumersExchangesToBinding(): List<ExchangeConsumer> {
        return listOf(
                ExchangeConsumer.ExchangeConsumer1,
                ExchangeConsumer.ExchangeConsumer2,
                ExchangeConsumer.ExchangeConsumer3
        )
    }

    @Bean
    fun binding(queue: Queue, consumersExchange: List<ExchangeConsumer>): Declarables {
        val declarables = ArrayList<Declarable>()
        consumersExchange.forEach {
            val ex = FanoutExchange(it.value, true, false)
            declarables.add(ex)
            val bind = BindingBuilder.bind(queue).to(ex)
            declarables.add(bind)
        }
        return Declarables(declarables)
    }

    @Bean
    fun loadProcessorsMap(
            @Qualifier("AmqpProcessor1") processor1: AmqpProcessor,
            @Qualifier("AmqpProcessor2") processor2: AmqpProcessor,
            @Qualifier("AmqpProcessor3") processor3: AmqpProcessor
    ): Map<ExchangeConsumer, AmqpProcessor> {
        return mapOf(
                Pair(ExchangeConsumer.ExchangeConsumer1, processor1),
                Pair(ExchangeConsumer.ExchangeConsumer2, processor2),
                Pair(ExchangeConsumer.ExchangeConsumer3, processor3)
        )
    }


}