package dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorResponse {
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("data")
    private Data data;

    @lombok.Data
    public static class Data {

        @JsonProperty("error")
        private String error;
        @JsonProperty("request")
        private String request;
        @JsonProperty("method")
        private String method;

    }
}
