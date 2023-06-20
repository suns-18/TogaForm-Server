package tgkt.togaform.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private String id;
    private String username;
    private String password;

    private Date startTime;
    private Date stopTime;

    private String status;

    private String createdBy;
    private Date creationDate;

    private String lastUpdatedBy;
    private Date lastUpdateDate;

}
