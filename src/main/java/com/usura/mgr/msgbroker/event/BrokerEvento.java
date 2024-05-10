package com.usura.mgr.msgbroker.event;

import org.springframework.context.ApplicationEvent;

public class BrokerEvento extends ApplicationEvent {
    
    private static final long serialVersionUID = 1L;
    
    public BrokerEvento(Object source) {
        super(source);
    }
}
