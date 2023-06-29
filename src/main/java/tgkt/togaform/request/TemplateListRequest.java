package tgkt.togaform.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tgkt.togaform.entity.Template;

@EqualsAndHashCode(callSuper = true)
@Data
public class TemplateListRequest
        extends Template {
    private int page;
    private int size;
}
