package tgkt.togaform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tgkt.togaform.entity.Quesnaire;

@Repository
@Mapper
public interface QuesnaireMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteById(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Quesnaire row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Quesnaire selectById(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Quesnaire> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int update(Quesnaire row);
}