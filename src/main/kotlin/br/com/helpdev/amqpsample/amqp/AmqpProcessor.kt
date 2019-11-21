package br.com.helpdev.amqpsample.amqp

interface AmqpProcessor {
    fun processor(message: ByteArray): Boolean
}