package tgkt.togaform.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class HttpResponse {
    private String code;
    private Object data;
    private String message;
}
