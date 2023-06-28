package tgkt.togaform.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Project {
    private String id;
    private String userId;

    private String projectName;
    private String description;

    private String createdBy;
    private Date creationDate;

    private String lastUpdatedBy;
    private Date lastUpdateDate;
}