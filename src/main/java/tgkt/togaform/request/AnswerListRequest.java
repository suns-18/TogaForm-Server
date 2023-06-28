package tgkt.togaform.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tgkt.togaform.entity.Answer;
@EqualsAndHashCode(callSuper = true)
@Data
public class AnswerListRequest extends Answer {
    private int start;
    private int limit;
}
