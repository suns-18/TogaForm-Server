package tgkt.togaform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgkt.togaform.entity.Project;
import tgkt.togaform.mapper.ProjectMapper;
import tgkt.togaform.util.UUIDUtil;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    public int insert(Project project) throws NullPointerException {
        if (project.getProjectName().isEmpty())
            return 0;
        project.setId(UUIDUtil.getOneUUID());
        return projectMapper.insert(project);
    }

    public int deleteById(Project project) {
        return projectMapper.deleteById(project.getId());
    }

    public int update(Project project) {
        return projectMapper.update(project);
    }

    public Project selectById(Project project) {
        return projectMapper.selectById(project);
    }
    public List<Project> selectAll(Project project) {
        if (project.getProjectName() != null &&
                !project.getProjectName().isEmpty())
            return projectMapper.selectByProjectName(project);

        return projectMapper.selectAll(project);
    }
}
