package tgkt.togaform.response;

import lombok.Data;

@Data
public class HttpResponse {
    private String code = "0";
    private Object data;
    private String message;
}
