package tgkt.togaform.response;

import lombok.Data;
import tgkt.togaform.entity.Question;

import java.io.Serializable;
import java.util.List;

@Data
public class QuestionStatResponse implements Serializable {
    private Question question;

    private List<StatMap> maps;
}

