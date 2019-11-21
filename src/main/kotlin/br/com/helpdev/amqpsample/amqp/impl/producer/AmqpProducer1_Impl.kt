package br.com.helpdev.amqpsample.amqp.impl.producer

import br.com.helpdev.amqpsample.amqp.AmqpProducer
import br.com.helpdev.amqpsample.amqp.ExchangeProducer
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component("AmqpProducer1")
class AmqpProducer1_Impl(rabbitTemplate: RabbitTemplate) : AmqpProducer(rabbitTemplate, ExchangeProducer.ExchangeProducer1)