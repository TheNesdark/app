package com.genoma.plus.utils;

import com.genoma.plus.controller.facturacion.dto.validacionrips.ResultadoProcesoDTO;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/utils/CamelCaseDeserializer.class */
public class CamelCaseDeserializer implements JsonDeserializer<ResultadoProcesoDTO> {
    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public ResultadoProcesoDTO m82deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonObject camelCaseObject = new JsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String camelCaseKey = toCamelCase(entry.getKey());
            camelCaseObject.add(camelCaseKey, entry.getValue());
        }
        return (ResultadoProcesoDTO) new Gson().fromJson(camelCaseObject, ResultadoProcesoDTO.class);
    }

    private String toCamelCase(String s) {
        return s.substring(0, 1).toLowerCase() + s.substring(1);
    }
}
