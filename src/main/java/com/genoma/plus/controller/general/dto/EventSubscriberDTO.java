package com.genoma.plus.controller.general.dto;

import java.util.function.Consumer;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/EventSubscriberDTO.class */
public class EventSubscriberDTO {
    private String eventType;
    private Consumer<String> consumer;

    public EventSubscriberDTO(String eventType, Consumer<String> consumer) {
        this.eventType = eventType;
        this.consumer = consumer;
    }

    public boolean shouldReceive(String eventType) {
        return this.eventType.equals(eventType);
    }

    public Consumer<String> getConsumer() {
        return this.consumer;
    }
}
