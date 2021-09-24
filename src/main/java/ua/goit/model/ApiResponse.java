package ua.goit.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {

    @SerializedName("code")
    Integer code;

    @SerializedName("type")
    String type;

    @SerializedName("message")
    String message;

    @Override
    public String toString() {
        return "ApiResponse:" +
                "\n  code=" + code +
                "\n  type='" + type + '\'' +
                "\n  message='" + message + '\'';
    }
}
