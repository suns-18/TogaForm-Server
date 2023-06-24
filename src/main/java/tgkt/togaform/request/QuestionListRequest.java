package tgkt.togaform.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tgkt.togaform.entity.Question;

@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionListRequest extends Question {
    private int start;
    private int limit;
}
