package tgkt.togaform.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import tgkt.togaform.entity.Project;
import tgkt.togaform.entity.Quesnaire;

import java.util.List;

@Data
@SuperBuilder
public class ProjectQuesnaireResponse {
    private Project project;
    private List<Quesnaire> quesnaires;
}
