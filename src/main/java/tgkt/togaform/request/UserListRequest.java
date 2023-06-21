package tgkt.togaform.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tgkt.togaform.entity.User;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserListRequest
        extends User {
    private int start;
    private int limit;
}
