package tgkt.togaform.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Question {
    @Id
    private String id;
    private String title;
    private boolean required;
    private String description;
    private int answerType;
    private List<AnswerSelection> selections;

    @Data
    public static class AnswerSelection {
        private String key;
        private String value;
    }
}
