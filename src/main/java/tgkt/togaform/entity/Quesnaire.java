package tgkt.togaform.entity;

import lombok.Data;

@Data
public class Quesnaire {
    private String id;
    private String title;
    private Integer surveyType;
    private String description;
    private String project;
}