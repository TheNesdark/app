package com.genoma.plus.controller.facturacion.dto.validacionrips;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/LocalDateTimeDeserializer.class */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public LocalDateTime m65deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String dateString = p.getText();
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return offsetDateTime.toLocalDateTime();
    }
}
