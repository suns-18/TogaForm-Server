package tgkt.togaform.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class HttpResponse {
    private int code;
    private Object data;
    private String message;
}
