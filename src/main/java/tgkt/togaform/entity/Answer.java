package tgkt.togaform.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
@Data
@Document
public class Answer {
    private String id;
    private String userId;
    private Date answerTime;
    private String quesnaire;
    private List<AnswerItem> answers;
}

@Data
class AnswerItem{
    protected String questionId;
    protected AnswerSelection answer;
}
