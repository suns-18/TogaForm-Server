package tgkt.togaform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data
        .mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "questionnaire")
public class Quesnaire {
    private String id;
    private String title;

    private Date createTime;
    private Date startTime;
    private Date endTime;

    private String surveyType;
    private String description;

    private String project;

    private List<Question> questions;
    private List<Integer> roles;
}