package tgkt.togaform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tgkt.togaform.entity.Quesnaire;

@Repository
@Mapper
public interface QuesnaireMapper {
    int deleteById(String id);
    int insert(Quesnaire row);

    Quesnaire selectById(String id);
    List<Quesnaire> selectByProject(Quesnaire quesnaire);
    List<Quesnaire> selectAll();
    int update(Quesnaire row);
}