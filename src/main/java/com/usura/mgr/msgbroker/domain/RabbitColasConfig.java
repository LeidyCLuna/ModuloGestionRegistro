package com.usura.mgr.msgbroker.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitColasConfig {

    @Bean("rutaMGR")
    public RabbitBindingRoute rutaSGA(
            @Value("${rabbitmq.routing.mgr.exchange}")
            String exchange,
            @Value("${rabbitmq.routing.mgr.routingKey}")
            String routingKey){
        return RabbitBindingRoute.builder().exchange(exchange).routingKey(routingKey).build();
    }
}
