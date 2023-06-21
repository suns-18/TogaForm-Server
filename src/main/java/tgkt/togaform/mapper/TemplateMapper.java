package tgkt.togaform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tgkt.togaform.entity.Template;

@Repository
@Mapper
public interface TemplateMapper {
    int insert(Template row);
    int deleteById(String id);
    int update(Template row);
    Template selectById(String id);
    List<Template> selectAll();
}