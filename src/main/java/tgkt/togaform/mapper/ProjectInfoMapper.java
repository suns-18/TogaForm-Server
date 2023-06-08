package tgkt.togaform.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import tgkt.togaform.entity.ProjectInfo;

@Repository
public interface ProjectInfoMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ProjectInfo row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ProjectInfo selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<ProjectInfo> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ProjectInfo row);
}