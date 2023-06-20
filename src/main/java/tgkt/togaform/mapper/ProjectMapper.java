package tgkt.togaform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tgkt.togaform.entity.Project;

@Repository
@Mapper
public interface ProjectMapper {
    int insert(Project row);
    int update(Project row);
    int deleteById(String id);
    Project selectById(Project p);
    List<Project> selectAll(Project p);
    List<Project> selectByProjectName(Project p);

}