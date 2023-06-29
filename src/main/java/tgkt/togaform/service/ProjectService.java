package tgkt.togaform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgkt.togaform.entity.Project;
import tgkt.togaform.entity.Quesnaire;
import tgkt.togaform.mapper.ProjectMapper;
import tgkt.togaform.repo.QuesnaireRepo;
import tgkt.togaform.request.ProjectListRequest;
import tgkt.togaform.request.QuesnaireListRequest;
import tgkt.togaform.response.ListResponse;
import tgkt.togaform.response.ProjectQuesnaireResponse;
import tgkt.togaform.util.UUIDUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {
    @Autowired
    private ProjectMapper mapper;
    @Autowired
    private QuesnaireService quesnaireService;

    public int insert(Project project) throws NullPointerException {
        if (project.getId() == null || project.getId().isEmpty())
            project.setId(UUIDUtil.getOneUUID());

        if (project.getProjectName() == null || project.getProjectName().equals(""))
            return 0;

        return mapper.insert(project);
    }

    public int deleteById(Project project) {
        if (project.getId() == null)
            return 0;
        return mapper.deleteById(project.getId());
    }

    public int update(Project project) {
        if (project.getProjectName() == null || project.getProjectName().equals(""))
            return 0;
        return mapper.update(project);
    }

    public Project selectById(Project project) {
        if (project.getId() == null) {
            return null;
        }
        return mapper.selectById(project);
    }

    public ListResponse selectAll(ProjectListRequest req) {

        var totalPage = req.getLimit() == 0 ? -1 :
                mapper.countAll(req) / req.getLimit() + 1;

        var currentPage = req.getLimit() == 0 ? -1 :
                (req.getStart() / req.getLimit()) + 1;

        return ListResponse.builder()
                .totalPage(totalPage)
                .data(mapper.selectAll(req))
                .currentPage(currentPage)
                .build();
    }

    public ListResponse selectAllExtended(ProjectListRequest req) {
        var projectResp = selectAll(req);
        List<ProjectQuesnaireResponse>
                respList = new ArrayList<>();
        List<Project> rawList = (List<Project>) projectResp.getData();

        rawList.forEach(item -> {
            var quesnaireReq = new QuesnaireListRequest();
            quesnaireReq.setProject(item.getId());

            var extendedItem = ProjectQuesnaireResponse.builder()
                    .project(item)
                    .quesnaires((List<Quesnaire>) quesnaireService
                            .selectByProject(quesnaireReq).getData())
                    .build();
            respList.add(extendedItem);
        });
        projectResp.setData(respList);
        return projectResp;
    }
}
