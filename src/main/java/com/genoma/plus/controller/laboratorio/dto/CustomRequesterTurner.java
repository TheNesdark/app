package com.genoma.plus.controller.laboratorio.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/CustomRequesterTurner.class */
public class CustomRequesterTurner {
    private int status;
    private String message;
    private String description;
    private boolean data;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CustomRequesterTurner)) {
            return false;
        }
        CustomRequesterTurner other = (CustomRequesterTurner) o;
        if (!other.canEqual(this) || getStatus() != other.getStatus() || isData() != other.isData()) {
            return false;
        }
        Object this$message = getMessage();
        Object other$message = other.getMessage();
        if (this$message == null) {
            if (other$message != null) {
                return false;
            }
        } else if (!this$message.equals(other$message)) {
            return false;
        }
        Object this$description = getDescription();
        Object other$description = other.getDescription();
        return this$description == null ? other$description == null : this$description.equals(other$description);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CustomRequesterTurner;
    }

    @Generated
    public int hashCode() {
        int result = (1 * 59) + getStatus();
        int result2 = (result * 59) + (isData() ? 79 : 97);
        Object $message = getMessage();
        int result3 = (result2 * 59) + ($message == null ? 43 : $message.hashCode());
        Object $description = getDescription();
        return (result3 * 59) + ($description == null ? 43 : $description.hashCode());
    }

    @Generated
    public String toString() {
        return "CustomRequesterTurner(status=" + getStatus() + ", message=" + getMessage() + ", description=" + getDescription() + ", data=" + isData() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/CustomRequesterTurner$CustomRequesterTurnerBuilder.class */
    @Generated
    public static class CustomRequesterTurnerBuilder {

        @Generated
        private int status;

        @Generated
        private String message;

        @Generated
        private String description;

        @Generated
        private boolean data;

        @Generated
        CustomRequesterTurnerBuilder() {
        }

        @Generated
        public CustomRequesterTurnerBuilder status(int status) {
            this.status = status;
            return this;
        }

        @Generated
        public CustomRequesterTurnerBuilder message(String message) {
            this.message = message;
            return this;
        }

        @Generated
        public CustomRequesterTurnerBuilder description(String description) {
            this.description = description;
            return this;
        }

        @Generated
        public CustomRequesterTurnerBuilder data(boolean data) {
            this.data = data;
            return this;
        }

        @Generated
        public CustomRequesterTurner build() {
            return new CustomRequesterTurner(this.status, this.message, this.description, this.data);
        }

        @Generated
        public String toString() {
            return "CustomRequesterTurner.CustomRequesterTurnerBuilder(status=" + this.status + ", message=" + this.message + ", description=" + this.description + ", data=" + this.data + ")";
        }
    }

    @Generated
    public void setStatus(int status) {
        this.status = status;
    }

    @Generated
    public void setMessage(String message) {
        this.message = message;
    }

    @Generated
    public void setDescription(String description) {
        this.description = description;
    }

    @Generated
    public void setData(boolean data) {
        this.data = data;
    }

    @Generated
    public static CustomRequesterTurnerBuilder builder() {
        return new CustomRequesterTurnerBuilder();
    }

    @Generated
    public CustomRequesterTurner(int status, String message, String description, boolean data) {
        this.status = status;
        this.message = message;
        this.description = description;
        this.data = data;
    }

    @Generated
    public CustomRequesterTurner() {
    }

    @Generated
    public int getStatus() {
        return this.status;
    }

    @Generated
    public String getMessage() {
        return this.message;
    }

    @Generated
    public String getDescription() {
        return this.description;
    }

    @Generated
    public boolean isData() {
        return this.data;
    }
}
