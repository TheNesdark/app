package com.genoma.plus.controller.general.dto;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/EventDataDTO.class */
public class EventDataDTO<T> {
    private String name;
    private T data;

    private EventDataDTO() {
    }

    public static <T> EventDataDTO<T> init() {
        return new EventDataDTO<>();
    }

    private EventDataDTO(String name, T data) {
        this.name = name;
        this.data = data;
    }

    public static <T> EventDataDTO<T> init(String name, T data) {
        return new EventDataDTO<>(name, data);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
