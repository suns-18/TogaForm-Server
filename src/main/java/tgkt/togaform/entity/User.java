package tgkt.togaform.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer Id;
    private String username;
    private String password;
    private String roleId;

    private String startTime;
    private String stopTime;

    private String status;

    private String createdBy;
    private String creationDate;

    private String lastUpdatedBy;
    private String lastUpdateDate;
}
