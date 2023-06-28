package tgkt.togaform.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import tgkt.togaform.entity.Quesnaire;

@Data
@SuperBuilder
public class QuesnaireFinishResponse {
    private Quesnaire quesnaire;
    private boolean finished;
}
