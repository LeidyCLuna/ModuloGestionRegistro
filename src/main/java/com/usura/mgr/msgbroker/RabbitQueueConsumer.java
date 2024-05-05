package com.usura.mgr.msgbroker;

import org.springframework.stereotype.Component;

@Component
public class RabbitQueueConsumer {
/*
    @Autowired
    IPreguntaService preguntaService;


    @RabbitListener(queues = "${rabbitmq.routing.sga.queue}", containerFactory = "listenerRabbit")
    // Cambiar DTO ajustar al dto consumidor
    public void receive(@Payload ListaPreguntasDto listaPreguntasDto, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag){
        try {
            String message = "";
            preguntaService.savepregunta(listaPreguntasDto);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }*/


}
