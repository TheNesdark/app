package com.genoma.plus.controller.facturacion.dto.validacionrips;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/CapitalizedNamingStrategy.class */
public class CapitalizedNamingStrategy extends PropertyNamingStrategies.NamingBase {
    public String translate(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return Character.toUpperCase(input.charAt(0)) + input.substring(1);
    }
}
