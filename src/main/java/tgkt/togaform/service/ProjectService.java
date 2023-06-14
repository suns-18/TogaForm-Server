package tgkt.togaform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgkt.togaform.entity.ProjectInfo;
import tgkt.togaform.mapper.ProjectInfoMapper;
import tgkt.togaform.util.UUIDUtil;

import java.util.List;

@Service
public class ProjectService {
	@Autowired
	private ProjectInfoMapper projectInfoMapper;

	public List<ProjectInfo> queryList(ProjectInfo projectInfo) {

		if (projectInfo.getId() != null &&
			!projectInfo.getId().isEmpty())
			return projectInfoMapper.queryById(projectInfo);

		if (projectInfo.getProjectName() != null &&
			!projectInfo.getProjectName().isEmpty())
			return projectInfoMapper.queryByProjectName(projectInfo);

		return projectInfoMapper.queryAll(projectInfo);
	}

	public int insert(ProjectInfo projectInfo) {
		if (projectInfo.getProjectName().isEmpty())
			return 0;
		projectInfo.setId(UUIDUtil.getOneUUID());
		return projectInfoMapper.insert(projectInfo);
	}

	public int update(ProjectInfo projectInfo) {
		return projectInfoMapper.update(projectInfo);
	}

	public int deleteById(ProjectInfo projectInfo) {
		return projectInfoMapper.deleteById(projectInfo.getId());
	}
}
