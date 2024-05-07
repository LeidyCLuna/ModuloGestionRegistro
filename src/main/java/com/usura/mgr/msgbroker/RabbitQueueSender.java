package com.usura.mgr.msgbroker;


import com.usura.mgr.dto.EstudianteDto;
import com.usura.mgr.msgbroker.domain.RabbitBindingRoute;
import jakarta.annotation.Resource;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitQueueSender {

    @Resource(name = "productorRabbit")
    RabbitTemplate productorRabbitDiscordia;

    CorrelationData confirmaCorrelation  = new CorrelationData();


    @Autowired
    private RabbitBindingRoute rabbitBindingRoute;
    // justar al dto
   public void send(EstudianteDto estudianteDto){
        productorRabbitDiscordia.convertAndSend(rabbitBindingRoute.getExchange(),rabbitBindingRoute.getRoutingKey(),estudianteDto,confirmaCorrelation);
    }
}
