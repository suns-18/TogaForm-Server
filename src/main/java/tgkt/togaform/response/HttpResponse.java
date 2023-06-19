package tgkt.togaform.response;

import lombok.Data;

@Data
public class HttpResponse {
    private String code;
    private Object data;
    private String message;
}
