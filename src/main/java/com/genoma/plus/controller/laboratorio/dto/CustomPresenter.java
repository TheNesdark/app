package com.genoma.plus.controller.laboratorio.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/CustomPresenter.class */
public class CustomPresenter {
    private String reason;
    private Integer statusCode;
    private String message;
    private String description;
    private Object data;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CustomPresenter)) {
            return false;
        }
        CustomPresenter other = (CustomPresenter) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$statusCode = getStatusCode();
        Object other$statusCode = other.getStatusCode();
        if (this$statusCode == null) {
            if (other$statusCode != null) {
                return false;
            }
        } else if (!this$statusCode.equals(other$statusCode)) {
            return false;
        }
        Object this$reason = getReason();
        Object other$reason = other.getReason();
        if (this$reason == null) {
            if (other$reason != null) {
                return false;
            }
        } else if (!this$reason.equals(other$reason)) {
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
        if (this$description == null) {
            if (other$description != null) {
                return false;
            }
        } else if (!this$description.equals(other$description)) {
            return false;
        }
        Object this$data = getData();
        Object other$data = other.getData();
        return this$data == null ? other$data == null : this$data.equals(other$data);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CustomPresenter;
    }

    @Generated
    public int hashCode() {
        Object $statusCode = getStatusCode();
        int result = (1 * 59) + ($statusCode == null ? 43 : $statusCode.hashCode());
        Object $reason = getReason();
        int result2 = (result * 59) + ($reason == null ? 43 : $reason.hashCode());
        Object $message = getMessage();
        int result3 = (result2 * 59) + ($message == null ? 43 : $message.hashCode());
        Object $description = getDescription();
        int result4 = (result3 * 59) + ($description == null ? 43 : $description.hashCode());
        Object $data = getData();
        return (result4 * 59) + ($data == null ? 43 : $data.hashCode());
    }

    @Generated
    public String toString() {
        return "CustomPresenter(reason=" + getReason() + ", statusCode=" + getStatusCode() + ", message=" + getMessage() + ", description=" + getDescription() + ", data=" + getData() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/CustomPresenter$CustomPresenterBuilder.class */
    @Generated
    public static class CustomPresenterBuilder {

        @Generated
        private String reason;

        @Generated
        private Integer statusCode;

        @Generated
        private String message;

        @Generated
        private String description;

        @Generated
        private Object data;

        @Generated
        CustomPresenterBuilder() {
        }

        @Generated
        public CustomPresenterBuilder reason(String reason) {
            this.reason = reason;
            return this;
        }

        @Generated
        public CustomPresenterBuilder statusCode(Integer statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        @Generated
        public CustomPresenterBuilder message(String message) {
            this.message = message;
            return this;
        }

        @Generated
        public CustomPresenterBuilder description(String description) {
            this.description = description;
            return this;
        }

        @Generated
        public CustomPresenterBuilder data(Object data) {
            this.data = data;
            return this;
        }

        @Generated
        public CustomPresenter build() {
            return new CustomPresenter(this.reason, this.statusCode, this.message, this.description, this.data);
        }

        @Generated
        public String toString() {
            return "CustomPresenter.CustomPresenterBuilder(reason=" + this.reason + ", statusCode=" + this.statusCode + ", message=" + this.message + ", description=" + this.description + ", data=" + this.data + ")";
        }
    }

    @Generated
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Generated
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
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
    public void setData(Object data) {
        this.data = data;
    }

    @Generated
    public static CustomPresenterBuilder builder() {
        return new CustomPresenterBuilder();
    }

    @Generated
    public CustomPresenter(String reason, Integer statusCode, String message, String description, Object data) {
        this.reason = reason;
        this.statusCode = statusCode;
        this.message = message;
        this.description = description;
        this.data = data;
    }

    @Generated
    public CustomPresenter() {
    }

    @Generated
    public String getReason() {
        return this.reason;
    }

    @Generated
    public Integer getStatusCode() {
        return this.statusCode;
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
    public Object getData() {
        return this.data;
    }
}
