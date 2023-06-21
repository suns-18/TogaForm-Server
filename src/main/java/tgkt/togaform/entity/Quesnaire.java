package tgkt.togaform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data
        .mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "questionaire")
public class Quesnaire {
    private String id;
    private String title;

    private Date createTime;

    private String surveyType;
    private String description;

    private String project;

    private List<String> questions;
    private List<Integer> roles;
}