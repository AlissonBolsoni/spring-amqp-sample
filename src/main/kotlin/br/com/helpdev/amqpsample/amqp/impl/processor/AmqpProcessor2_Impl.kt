package br.com.helpdev.amqpsample.amqp.impl.processor

import br.com.helpdev.amqpsample.amqp.AmqpProcessor
import org.springframework.stereotype.Component

@Component("AmqpProcessor2")
class AmqpProcessor2_Impl : AmqpProcessor {

    override fun processor(message: ByteArray): Boolean {
        println("============AmqpProcessor2_Impl====================")
        println("PROCESSING MESSAGE: ${String(message)}")
        Thread.sleep(2000)
        println("MESSAGE PROCESSED!... ")
        println("====================================================")
        return true
    }

}