package tgkt.togaform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgkt.togaform.entity.Project;
import tgkt.togaform.mapper.ProjectMapper;
import tgkt.togaform.request.ProjectListRequest;
import tgkt.togaform.response.ListResponse;
import tgkt.togaform.util.UUIDUtil;

@Service
public class ProjectService {
    @Autowired
    private ProjectMapper mapper;

    public int insert(Project project) throws NullPointerException {
        if (project.getProjectName().isEmpty())
            return 0;
        project.setId(UUIDUtil.getOneUUID());
        return mapper.insert(project);
    }

    public int deleteById(Project project) {
        return mapper.deleteById(project.getId());
    }

    public int update(Project project) {
        return mapper.update(project);
    }

    public Project selectById(Project project) {
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
}
