package br.com.helpdev.amqpsample.amqp.impl.processor

import br.com.helpdev.amqpsample.amqp.AmqpProcessor
import br.com.helpdev.amqpsample.amqp.impl.producer.AmqpProducer2_Impl
import org.springframework.stereotype.Component

@Component("AmqpProcessor3")
class AmqpProcessor3_Impl(
        private val producer2Impl: AmqpProducer2_Impl
) : AmqpProcessor {

    override fun processor(message: ByteArray): Boolean {
        println("============AmqpProcessor3_Impl====================")
        println("PROCESSING MESSAGE: ${String(message)}")
        Thread.sleep(1000)
        println("MESSAGE PROCESSED!... SENDING RESPONSE")
        Thread.sleep(1000)
        producer2Impl.send(String(message))
        println("MESSAGE SENT")
        println("====================================================")
        return true
    }

}