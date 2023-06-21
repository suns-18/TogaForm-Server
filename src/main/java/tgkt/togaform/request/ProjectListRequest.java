package tgkt.togaform.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tgkt.togaform.entity.Project;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectListRequest
        extends Project {
    private int start;
    private int limit;
}
