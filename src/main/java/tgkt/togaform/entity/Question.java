package tgkt.togaform.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Question {
    private String id;
    private String title;
    private boolean required;
    private String description;
    private int answerType;
    private AnswerSelection answerSelection;
    private String template;
}
