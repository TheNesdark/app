package com.genoma.plus.controller.facturacion.dto;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/UsuarioResponse.class */
public class UsuarioResponse {
    private String token;
    private boolean login;
    private boolean registrado;
    private List<String> errors;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/UsuarioResponse$UsuarioResponseBuilder.class */
    @Generated
    public static class UsuarioResponseBuilder {

        @Generated
        private String token;

        @Generated
        private boolean login;

        @Generated
        private boolean registrado;

        @Generated
        private List<String> errors;

        @Generated
        UsuarioResponseBuilder() {
        }

        @Generated
        public UsuarioResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        @Generated
        public UsuarioResponseBuilder login(boolean login) {
            this.login = login;
            return this;
        }

        @Generated
        public UsuarioResponseBuilder registrado(boolean registrado) {
            this.registrado = registrado;
            return this;
        }

        @Generated
        public UsuarioResponseBuilder errors(List<String> errors) {
            this.errors = errors;
            return this;
        }

        @Generated
        public UsuarioResponse build() {
            return new UsuarioResponse(this.token, this.login, this.registrado, this.errors);
        }

        @Generated
        public String toString() {
            return "UsuarioResponse.UsuarioResponseBuilder(token=" + this.token + ", login=" + this.login + ", registrado=" + this.registrado + ", errors=" + this.errors + ")";
        }
    }

    @Generated
    public void setToken(String token) {
        this.token = token;
    }

    @Generated
    public void setLogin(boolean login) {
        this.login = login;
    }

    @Generated
    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

    @Generated
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Generated
    public static UsuarioResponseBuilder builder() {
        return new UsuarioResponseBuilder();
    }

    @Generated
    public UsuarioResponse(String token, boolean login, boolean registrado, List<String> errors) {
        this.token = token;
        this.login = login;
        this.registrado = registrado;
        this.errors = errors;
    }

    @Generated
    public UsuarioResponse() {
    }

    @Generated
    public String getToken() {
        return this.token;
    }

    @Generated
    public boolean isLogin() {
        return this.login;
    }

    @Generated
    public boolean isRegistrado() {
        return this.registrado;
    }

    @Generated
    public List<String> getErrors() {
        return this.errors;
    }
}
