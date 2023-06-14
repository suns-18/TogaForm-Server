package tgkt.togaform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tgkt.togaform.entity.ProjectInfo;

@Repository
@Mapper
public interface ProjectInfoMapper {


	int insert(ProjectInfo row);

	int update(ProjectInfo row);

	int deleteById(String id);

	List<ProjectInfo> queryAll(ProjectInfo p);

	List<ProjectInfo> queryById(ProjectInfo p);

	List<ProjectInfo> queryByProjectName(ProjectInfo p);


}