package dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DelImgResponse {
    @JsonProperty("data")
    private Boolean data;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("status")
    private Integer status;
}
