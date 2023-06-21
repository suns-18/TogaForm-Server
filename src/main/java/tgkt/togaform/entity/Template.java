package tgkt.togaform.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Template {
    private String id;

    private String title;

    private Date createTime;

    private String description;
}