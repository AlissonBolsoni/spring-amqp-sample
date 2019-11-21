package br.com.helpdev.amqpsample.amqp

import java.lang.IllegalArgumentException

sealed class ExchangeConsumer(value: String) : Exchange(value) {
    object ExchangeConsumer1 : ExchangeConsumer(EXCHANGE_1)
    object ExchangeConsumer2 : ExchangeConsumer(EXCHANGE_2)
    object ExchangeConsumer3 : ExchangeConsumer(EXCHANGE_3)

    companion object {
        private const val EXCHANGE_1 = "exchange.server.1"
        private const val EXCHANGE_2 = "exchange.server.2"
        private const val EXCHANGE_3 = "exchange.server.3"

        fun byName(name: String): ExchangeConsumer {
            return when (name) {
                EXCHANGE_1 -> ExchangeConsumer1
                EXCHANGE_2 -> ExchangeConsumer2
                EXCHANGE_3 -> ExchangeConsumer3
                else -> throw IllegalArgumentException("No exchange found")
            }
        }
    }
}

sealed class ExchangeProducer(value: String) : Exchange(value) {
    object ExchangeProducer1 : ExchangeProducer("exchange.client.1")
    object ExchangeProducer2 : ExchangeProducer("exchange.client.2")
}

sealed class Exchange(val value: String) {
    override fun toString(): String {
        return "Exchange(value='$value')"
    }
}