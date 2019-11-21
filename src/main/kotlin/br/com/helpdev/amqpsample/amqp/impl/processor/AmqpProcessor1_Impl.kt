package br.com.helpdev.amqpsample.amqp.impl.processor

import br.com.helpdev.amqpsample.amqp.AmqpProcessor
import br.com.helpdev.amqpsample.amqp.impl.producer.AmqpProducer1_Impl
import org.springframework.stereotype.Component

@Component("AmqpProcessor1")
class AmqpProcessor1_Impl(
        private val producer1Impl: AmqpProducer1_Impl
) : AmqpProcessor {

    override fun processor(message: ByteArray): Boolean {
        println("============AmqpProcessor1_Impl====================")
        println("PROCESSING MESSAGE: ${String(message)}")
        Thread.sleep(1000)
        println("MESSAGE PROCESSED!... SENDING RESPONSE")
        Thread.sleep(1000)
        producer1Impl.send(String(message))
        println("MESSAGE SENT")
        println("====================================================")
        return true
    }

}