package tgkt.togaform.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import tgkt.togaform.entity.Quesnaire;

@EqualsAndHashCode(callSuper = true)
@Data
public class QuesnaireListRequest
        extends Quesnaire {
    private int start;
    private int limit;
}
