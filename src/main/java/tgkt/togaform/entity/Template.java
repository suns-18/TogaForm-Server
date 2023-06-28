package tgkt.togaform.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Template {
    @Id
    private String id;
    private String title;
    private Date createTime;
    private String description;

    private List<Question> questions;
}