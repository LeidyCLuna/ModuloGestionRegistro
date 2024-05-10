package com.usura.mgr.msgbroker.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmarBrokerEvento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private boolean ack;
    private String reason;
    
}
