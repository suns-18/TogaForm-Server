package tgkt.togaform.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
@Data
@Document
public class Answer {
    @Id
    private String id;
    private String userId;
    private Date answerTime;
    private String quesnaire;
    private List<AnswerItem> answers;
}

@Data
class AnswerItem{
    protected List<String> answer;
}
@Data
class AnswerSelection {
    protected String key;
    protected String value;
}
