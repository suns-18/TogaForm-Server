package tgkt.togaform.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class ListResponse extends HttpResponse{
    private int totalPage;
    private int currentPage;
}
