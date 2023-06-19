package tgkt.togaform.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserListResponse extends HttpResponse{
    private int currentPage;
    private int totalPage;
}
